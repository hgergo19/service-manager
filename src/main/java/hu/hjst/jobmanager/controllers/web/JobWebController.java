package hu.hjst.jobmanager.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobWebController {

    @GetMapping("/new-job")
    public String getAddNewJob(){
        return "new-job";
    }
}
