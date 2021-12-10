package hu.hjst.jobmanager.repositories;

import hu.hjst.jobmanager.models.entities.Job;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {

    boolean existsByJobId(Long id);

    List<Job> findAll();
}
