package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.JobCreateDto;
import hu.hjst.jobmanager.models.dtos.JobDto;
import hu.hjst.jobmanager.models.entities.Job;
import hu.hjst.jobmanager.repositories.JobRepository;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
public class DefaultJobService implements JobService {

    private final JobRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public DefaultJobService(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobDto newJob(JobCreateDto dto) {
        Job jobEntity = mapper.map(dto, Job.class);
        //create first
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

        //TODO null and valid  checks
        //TODO create tests

        repository.save(jobEntity);
        return mapper.map(jobEntity, JobDto.class);
    }

    @Override
    public JobDto findJobByJobId(Long jobId) {
        //TODO : IMPLEMENTATION
        return null;
    }

    @Override
    public List<JobDto> findAllJobs() {
        //TODO : IMPLEMENTATION
        return null;
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

    @Override
    public void deleteJobById(Long jobId) {
        //TODO : IMPLEMENTATION
    }

    @Override
    public void modifyJobById(Long jobId) {
        //TODO : IMPLEMENTATION
    }
}
