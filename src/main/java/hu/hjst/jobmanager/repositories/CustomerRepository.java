package hu.hjst.jobmanager.repositories;

import hu.hjst.jobmanager.models.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  Boolean existsByCompanyNameIgnoreCase(String companyName);

  List<Customer> findAll();
}
