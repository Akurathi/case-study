package com.example.salesorderservice.service;


import com.example.salesorderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="sales-order-service", url = "http://localhost:9192/")
public interface CustomerServiceProxy {

//    @GetMapping("owner-service/ownerapi/owner/getById/{id}")
//    Owner getCustomerById(@PathVariable("id") long id);

    @GetMapping("customerController/getEmail/{email}")
    Customer getByEmail(@PathVariable("email") String email);
}
