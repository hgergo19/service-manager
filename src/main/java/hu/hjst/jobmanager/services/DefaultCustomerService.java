package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;
import hu.hjst.jobmanager.models.dtos.CustomerResponseDto;
import hu.hjst.jobmanager.models.entities.Customer;
import hu.hjst.jobmanager.repositories.CustomerRepository;
import hu.hjst.jobmanager.utils.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final CustomerRepository repository;


  @Autowired
  public DefaultCustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public CustomerResponseDto newCustomer(CustomerCreateDto dto) {
    Validator.validate(dto);
    if (repository.existsByCompanyNameIgnoreCase(dto.getCompanyName())){
      throw new IllegalArgumentException("Company already exists"); //TODO : controller level exception handling (later REST)/ error pages
    }
    Customer customer = modelMapper.map(dto, Customer.class);
    return null;
  }

  @Override
  public CustomerResponseDto findCustomerById(Long id) {
    return null;
  }

  @Override
  public CustomerResponseDto findCustomerByName(String name) {
    return null;
  }

  @Override
  public void deleteCustomerById(Long id) {
  }

  @Override
  public void modifyCustomerById(Long id) {
  }
}
