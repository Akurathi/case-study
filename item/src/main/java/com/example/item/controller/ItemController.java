package com.example.item.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customerController")
public class ItemController {

    private CustomerService customerService;

    public ItemController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping(value = "addCustomer" , produces = "application/json")
    public Customer add(@RequestBody Customer customer) {
        System.out.println("----Coming inside the controller---add-");
        return this.customerService.add(customer);
    }


//    @GetMapping(value = "getEmail/{email}", produces = "application/json")
//    public Customer get(@PathVariable("email") String email) {
//        System.out.println("----Coming inside the controller---get-");
//        System.out.println(email);
//        System.out.println("**********" + this.customerService.get(email));
//        return this.customerService.get(email);
//    }

    @GetMapping(value = "getEmail", produces = "application/json")
    public Customer get(@RequestBody final String email) {
        System.out.println("----Coming inside the controller---get-");
        System.out.println(email);
        return this.customerService.get(email);
    }


    @GetMapping(value = "getAllCustomers" , produces = "application/json")
    public List<Customer> getAll() {
        System.out.println("----Coming inside the controller---getAll-");
        return this.customerService.getAll();
    }



}
