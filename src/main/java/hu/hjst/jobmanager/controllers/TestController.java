package hu.hjst.jobmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/new-job")
    public String getNewJob(){
        return "new-job";
    }
}
