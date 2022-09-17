package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.JobCreateDto;
import hu.hjst.jobmanager.models.dtos.JobDto;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static hu.hjst.jobmanager.utils.Validator.validate;

@Service
@Getter
public class DefaultJobService implements JobService {

    private final JobRepository repository;
    private final MachineRepository machineRepository;
    private final ModelMapper mapper = new ModelMapper();

    public DefaultJobService(JobRepository repository, MachineRepository machineRepository) {
        this.repository = repository;

        this.machineRepository = machineRepository;
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
    public List<JobDto> findAllJobs(String status) {

        Status s = Status.valueOf(status);
        Validator.validate(s, "Invalid status input!");

        List<Job> allJobs = repository.findByStatus(s);
        List<JobDto> response = new ArrayList<>();

        for (Job job : allJobs) {
            response.add(mapper.map(job, JobDto.class));
        }
        return response;
    }

    @Override
    public List<JobDto> findJobsByMachineNumber() {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public List<JobDto> findJobsByCustomers() {
        //TODO : IMPLEMENTATION
        return null;
    }

    //TODO : find all jobs --> with argument (isActive set to default yes)
    @Override
    public List<JobDto> findActiveJobs() {
        List<Job> allActive = repository.findAllActive();
        List<JobDto> response = new ArrayList<>();
        for (Job job : allActive) {
            response.add(mapper.map(job, JobDto.class));
        }
        return response;
    }

    @Override
    public void deleteJobById(Long jobId) {
        //TODO : IMPLEMENTATION
    }

    @Override
    public void modifyJobById(Long jobId) {
        //TODO : IMPLEMENTATION
    }

    private void setMachineOfJob(String machineNumber, Job job) {
        Machine m;
        Optional<Machine> byId = machineRepository.findById(machineNumber);
        m = byId.orElseThrow(IllegalArgumentException::new);
        job.setMachine(m);
    }
}
