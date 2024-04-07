package com.networking.demo.controller;


import com.networking.demo.model.RegisterBody;
import com.networking.demo.service.CustomerService;
import com.networking.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final int test_variable = 8;
    @GetMapping("/testVariable2")
    public int getTestVariable() {
        return test_variable;
    }

    @PostMapping("/SignUp")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody RegisterBody body) {
        customerService.signUp(body.email(), body.password(), body.firstName(), body.lastName());
    }
}
