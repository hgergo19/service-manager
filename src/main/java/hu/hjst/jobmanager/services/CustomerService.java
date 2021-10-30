package hu.hjst.jobmanager.services;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;
import hu.hjst.jobmanager.models.dtos.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

  CustomerResponseDto newCustomer(CustomerCreateDto dto);

  CustomerResponseDto findCustomerById(Long id);

  CustomerResponseDto findCustomerByName(String name);

  List<CustomerResponseDto> listCustomers();

  void deleteCustomerById(Long id);

  void modifyCustomerById(Long id);
}
