package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;
import hu.hjst.jobmanager.models.dtos.CustomerResponseDto;

public interface CustomerService {

  CustomerResponseDto newCustomer(CustomerCreateDto dto);

  CustomerResponseDto findCustomerById(Long id);

  CustomerResponseDto findCustomerByName(String name);

  void deleteCustomerById(Long id);

  void modifyCustomerById(Long id);
}
