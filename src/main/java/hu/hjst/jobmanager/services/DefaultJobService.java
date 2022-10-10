package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.CustomerResponseDto;
import hu.hjst.jobmanager.models.dtos.JobCreateDto;
import hu.hjst.jobmanager.models.dtos.JobDto;
import hu.hjst.jobmanager.models.dtos.JobModifyDto;
import hu.hjst.jobmanager.models.entities.Job;
import hu.hjst.jobmanager.models.entities.Machine;
import hu.hjst.jobmanager.models.enums.Status;
import hu.hjst.jobmanager.repositories.JobRepository;
import hu.hjst.jobmanager.repositories.MachineRepository;
import hu.hjst.jobmanager.utils.Validator;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static hu.hjst.jobmanager.utils.Validator.validate;

@Service
@Getter
public class DefaultJobService implements JobService {

    private final JobRepository repository;
    private final MachineRepository machineRepository;
    private final CustomerService customerService;
    private final ModelMapper mapper = new ModelMapper();

    public DefaultJobService(JobRepository repository, MachineRepository machineRepository, CustomerService customerService) {
        this.repository = repository;
        this.machineRepository = machineRepository;
        this.customerService = customerService;
    }

    @Override
    public JobDto newJob(JobCreateDto dto) {
        //validate job data
        validate(dto, "Object must not be null!");
        validate(dto.getSerialNumber(), "You must choose a machine for a job!!");

        //convert dto to entity
        Job jobEntity = mapper.map(dto, Job.class);

        setMachineOfJob(dto.getSerialNumber(), jobEntity);

        //set date to  today if not present
        if (jobEntity.getStartDate() == null) {
            jobEntity.setStartDate(LocalDate.now());
        }

        //create first id in current year if not exists
        List<Job> all = repository.findAll();
        if (all.isEmpty()) {
            jobEntity.initFirstId();
        } else {
            List<Long> jobIds = all.stream()
                    .map(Job::getJobId)
                    .sorted(Collections
                            .reverseOrder())
                    .collect(Collectors.toList());

            jobEntity.generateId(jobIds.get(0));
        }
        jobEntity.setIsCompleted(false);
        jobEntity.setIsInvoiced(false);
        jobEntity.setStatus(Status.IN_PROGRESS);
        repository.save(jobEntity);
        return mapper.map(jobEntity, JobDto.class);
    }

    @Override
    public JobDto findJobByJobId(Long jobId) {
        Validator.validate(jobId, "Id must not be null!");
        Optional<Job> jobResult = repository.findById(jobId);

        return jobResult.map(j -> mapper.map(j, JobDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Job with ID : " + jobId + " not exists!"));
    }

    @Override
    public List<JobDto> findJobsByStatus(String status) {
        Status s = Status.fromString(status);
        List<Job> allJobs = repository.findByStatus(s);
        return entityWrapper(allJobs);
    }

    @Override
    public List<JobDto> findJobsByMachineNumber(String serialNumber) {
        Validator.validate(serialNumber, "Serial number must be filled!");

        Optional<Machine> machineOptional = machineRepository.findById(serialNumber);
        Machine machine = machineOptional.orElseThrow(()
                -> new IllegalArgumentException("No machine  was fount with serial number :" + serialNumber));
        List<Job> jobsByMachine = repository.findByMachine(machine);

        return entityWrapper(jobsByMachine);
    }

    @Override
    public List<JobDto> findJobsByCustomer(String customerName) {
        Validator.validate(customerName, "Invalid customer name!");
        CustomerResponseDto customer = customerService.findCustomerByName(customerName);
        List<Machine> machines = customer.getMachines();
        List<List<Job>> jobs = new ArrayList<>();

        for (Machine machine : machines) {
            List<Job> byMachine = repository.findByMachine(machine);
            jobs.add(byMachine);
        }

        List<Job> collect = jobs.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return entityWrapper(collect);
    }

    @Override
    public List<JobDto> findActiveJobs() {
        List<Job> allActive = repository.findAllActive();
        return entityWrapper(allActive);
    }

    //TODO cascade to service report?
    @Override
    public void deleteJobById(Long jobId) {
        Validator.validate(jobId, "Job id must not be NULL!");
        Job j = findAndGetById(jobId);
        repository.delete(j);
    }

    @Override
    public void modifyJobById(Long jobId, JobModifyDto dto) {
        Validator.validate(jobId, "Job id must not be NULL!");
        Validator.validate(dto, "Data must not be NULL!");

        Job j = findAndGetById(jobId);
        LocalDate endDate = dto.getEndDate();
        LocalDate startDate = j.getStartDate();
        //TODO: test this !!
        if (endDate != null) {
            if (endDate.isAfter(startDate) || endDate.isEqual(startDate)) {
                j.setEndDate(endDate);
            }
        }

        String status = dto.getStatus();
        Status s = Status.valueOf(status);
        j.setStatus(s);

        if (s.equals(Status.CLOSED)) {
            j.setIsCompleted(true);
        }
        if (s.equals(Status.INVOICED)) {
            j.setIsInvoiced(true);
            j.setIsCompleted(true);
        }

        String invoice = dto.getInvoiceNumber();
        Validator.validate(invoice, "Invoice number cannot be null or empty!");
        j.setInvoiceNumber(invoice);


        String note = dto.getNote();
        Validator.validate(note, "Note number cannot be null or empty!");
        j.setNote(note);

    }

    private void setMachineOfJob(String machineNumber, Job job) {
        Machine m;
        Optional<Machine> byId = machineRepository.findById(machineNumber);
        m = byId.orElseThrow(IllegalArgumentException::new);
        job.setMachine(m);
    }

    private List<JobDto> entityWrapper(List<Job> jobs) {
        List<JobDto> response = new ArrayList<>();
        for (Job job : jobs) {
            response.add(mapper.map(job, JobDto.class));
        }
        return response;
    }

    private Job findAndGetById(Long id) {
        Optional<Job> job = repository.findById(id);
        return job.orElseThrow(() -> new IllegalArgumentException("No job was found with id : " + id));
    }
}
