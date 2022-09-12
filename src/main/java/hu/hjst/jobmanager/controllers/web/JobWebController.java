package hu.hjst.jobmanager.controllers.web;

import hu.hjst.jobmanager.models.dtos.JobCreateDto;
import hu.hjst.jobmanager.models.dtos.JobDto;
import hu.hjst.jobmanager.models.entities.Machine;
import hu.hjst.jobmanager.services.CustomerService;
import hu.hjst.jobmanager.services.JobService;
import hu.hjst.jobmanager.services.MachineService;
import hu.hjst.jobmanager.utils.Validator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobWebController {

    private JobService service;
    private CustomerService customerService;
    private MachineService machineService;

    public JobWebController(JobService service,
                            CustomerService customerService,
                            MachineService machineService) {

        this.service = service;
        this.customerService = customerService;
        this.machineService = machineService;
    }

    @GetMapping("/jobs-home")
    public String getAddNewJob(Model model) {
        List<JobDto> activeJobs = service.findActiveJobs();
        model.addAttribute("jobs", activeJobs);
        return "jobs-home";
    }

    @GetMapping("/add-new-job")
    public String addNewJobCustomerSelector(Model m) {
        m.addAttribute("customers", customerService.listCustomers());
        return "add-new-job-select-customer";
    }

    @PostMapping("/select-customer")
    public String selectCustomer(Long id) {
        Validator.validate(id, "ID cannot be null!");
        return "redirect:add-new-job/" + id;
    }

    @GetMapping("/add-new-job/{id}")
    public String addNewJobForm(@PathVariable Long id, Model m) {
        List<Machine> machinesByCustomer = machineService.findMachinesByCustomer(id);
        m.addAttribute("machines", machinesByCustomer);
        m.addAttribute("customer", customerService.findCustomerById(id));
        return "add-new-job-details";
    }

    @PostMapping("/add-new-job")
    public String addNewJob(JobCreateDto dto) {
        Validator.validate(dto, "Body cannot be null!");
        System.out.println(dto);
        service.newJob(dto);
        return "redirect:jobs-home";
    }

}
