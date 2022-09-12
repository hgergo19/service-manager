package hu.hjst.jobmanager.repositories;

import hu.hjst.jobmanager.models.entities.Machine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MachineRepository extends CrudRepository<Machine, String> {

    List<Machine> findAll();

    @Query(nativeQuery = true, value = "SELECT * FROM machines WHERE customer_id = ?1")
    List<Machine> findByCustomerId(Integer id);
}