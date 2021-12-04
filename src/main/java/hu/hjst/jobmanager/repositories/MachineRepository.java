package hu.hjst.jobmanager.repositories;

import hu.hjst.jobmanager.models.entities.Machine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MachineRepository extends CrudRepository<Machine, String> {

    List<Machine> findAll();
}