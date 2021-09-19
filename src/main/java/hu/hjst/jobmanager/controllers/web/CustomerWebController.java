package hu.hjst.jobmanager.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerWebController {

  @GetMapping("/new-customer")
  public String customerCreate() {
    return "new-customer";
  }
}
