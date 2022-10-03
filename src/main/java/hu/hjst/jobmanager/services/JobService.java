package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.JobCreateDto;
import hu.hjst.jobmanager.models.dtos.JobDto;
import hu.hjst.jobmanager.models.dtos.JobModifyDto;

import java.util.List;

public interface JobService {

    JobDto newJob(JobCreateDto dto);

    JobDto findJobByJobId(Long jobId);

    List<JobDto> findJobsByStatus(String status);

    List<JobDto> findJobsByMachineNumber(String serialNumber);

    List<JobDto> findJobsByCustomer(String customerName);

    List<JobDto> findActiveJobs();

    void deleteJobById(Long jobId); //ONLY ADMIN

    void modifyJobById(Long jobId, JobModifyDto dto); //ONLY ADMIN
}
