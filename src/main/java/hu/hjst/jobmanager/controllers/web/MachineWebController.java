package hu.hjst.jobmanager.controllers.web;

import hu.hjst.jobmanager.models.dtos.MachineCreateDto;
import hu.hjst.jobmanager.services.CustomerService;
import hu.hjst.jobmanager.services.MachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MachineWebController {

    private MachineService machineService;
    private CustomerService customerService;

    public MachineWebController(MachineService machineService, CustomerService customerService) {
        this.machineService = machineService;
        this.customerService = customerService;
    }

    @GetMapping("/new-machine")
    public String customerCreate(Model m) {
        m.addAttribute("customers", customerService.listCustomers());
        return "new-machine";
    }
    @PostMapping("/new-machine")
    public String addCustomer(MachineCreateDto dto) {
       machineService.newMachine(dto);
        return "redirect:/customers";
    }
}
