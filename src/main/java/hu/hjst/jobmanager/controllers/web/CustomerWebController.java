package hu.hjst.jobmanager.controllers.web;

import hu.hjst.jobmanager.models.dtos.CustomerCreateDto;
import hu.hjst.jobmanager.models.dtos.CustomerResponseDto;
import hu.hjst.jobmanager.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerWebController {

    private final CustomerService customerService;

  public CustomerWebController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/customer-home")
  public String customerCreate() {
    return "new-customer-home";
  }

  @PostMapping("/new-customer")
  public String addCustomer(CustomerCreateDto dto) {
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
    return "new-customers";
  }

    @PostMapping("/deleteCustomerById")
    public String deleteCustomerById(@RequestParam("id") Long buyerId) {
        customerService.deleteCustomerById(buyerId);
        return "redirect:/customers";
    }

    @GetMapping("/customer/{id}")
    public String customerDetailsPage(Model model, @PathVariable Long id) {  //TODO id validity check
        CustomerResponseDto customerById = customerService.findCustomerById(id);
        model.addAttribute("customer",customerById);
        model.addAttribute("machines",customerById.getMachines());
      System.out.println(customerById.getMachines());
        return "customer-details";
    }
}
