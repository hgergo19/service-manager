package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.JobCreateDto;
import hu.hjst.jobmanager.models.dtos.JobDto;

import java.util.List;

public interface JobService {

    JobDto newJob (JobCreateDto dto);

    JobDto findJobByJobId(Long jobId);

    List<JobDto> findAllJobs();

    List<JobDto> findJobsByMachineNumber();

    List<JobDto> findJobsByCustomers();

    void deleteJobById(Long jobId); //ONLY ADMIN

    void modifyJobById(Long jobId); //ONLY ADMIN
}
