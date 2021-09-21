package hu.hjst.jobmanager.controllers.web;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;
import hu.hjst.jobmanager.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerWebController {

  private CustomerService customerService;

  public CustomerWebController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/new-customer")
  public String customerCreate() {
    return "new-customer";
  }

  @PostMapping("new-customer")
  public String addCustomer(CustomerCreateDto dto) {
    System.out.println(dto);
    return "new-customer";
  }
}
