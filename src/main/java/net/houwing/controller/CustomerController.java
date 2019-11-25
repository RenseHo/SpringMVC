package net.houwing.controller;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ComponentScan(basePackages = "net.houwing")
//@RequestMapping("/")
public class CustomerController {


    @GetMapping("/customers")
    public String getCustomer () {
        return "Hello Customer van Customer.";
    }
}
