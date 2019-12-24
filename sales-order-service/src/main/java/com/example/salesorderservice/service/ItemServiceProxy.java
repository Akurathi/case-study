package com.example.salesorderservice.service;

import com.example.salesorderservice.model.Customer;
import com.example.salesorderservice.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="sales-order-service1", url = "http://localhost:8081/")
public interface ItemServiceProxy {



    @GetMapping(value = "itemController/items/{item}", produces = "application/json")
    Item get(@PathVariable("item") String item);
}