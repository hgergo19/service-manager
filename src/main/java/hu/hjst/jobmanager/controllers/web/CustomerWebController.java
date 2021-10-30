package hu.hjst.jobmanager.controllers.web;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;
import hu.hjst.jobmanager.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerWebController {

  private CustomerService customerService;

  public CustomerWebController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/customer-home")
  public String customerCreate() {
    return "customer-home";
  }

  @PostMapping("/new-customer")
  public String addCustomer(CustomerCreateDto dto) {
    System.out.println(dto.getNote());
    customerService.newCustomer(dto);
    return "redirect:/customers";
  }

  @GetMapping("/new-customer")
  public String addCustomer() {
    return "new-customer";
  }

  @GetMapping("/customers")
  public String listCustomers(Model model) {
    model.addAttribute("customers", customerService.listCustomers());
    return "customers";
  }
}
