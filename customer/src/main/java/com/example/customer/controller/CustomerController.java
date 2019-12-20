package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("customerController")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping(value = "addCustomer" , produces = "application/json")
    public Customer add(@RequestBody Customer customer) {
        System.out.println("----Coming inside the controller---add-");
        return this.customerService.add(customer);
    }


    @GetMapping("/getEmail/{email}")
    public Customer getByEmail(@PathVariable("email") String email) {
        System.out.println("----Coming inside the controller---get-");
        System.out.println(email);
        System.out.println("**********" + this.customerService.getByEmail(email));
       return this.customerService.getByEmail(email);
    }

//    @GetMapping(value = "getEmail", produces = "application/json")
//    public Customer get(@RequestBody final String email) {
//        System.out.println("----Coming inside the controller---get-");
//        System.out.println(email);
//        return this.customerService.get(email);
//    }


    @GetMapping(value = "getAllCustomers" , produces = "application/json")
    public List<Customer> getAll() {
        System.out.println("----Coming inside the controller---getAll-");
        return this.customerService.getAll();
    }



}
