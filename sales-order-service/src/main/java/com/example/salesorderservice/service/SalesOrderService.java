package com.example.salesorderservice.service;


import com.example.salesorderservice.model.SalesOrder;
import com.example.salesorderservice.model.customDetails;
import com.example.salesorderservice.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;


@Service
public class SalesOrderService {

    private SalesOrderRepository salesOrderRepository;

    public SalesOrderService(SalesOrderRepository salesOrderRepository) {

        this.salesOrderRepository = salesOrderRepository;
    }

    public SalesOrder add(Date Date, String Email, String Description, Double Price) {

        System.out.println("----Inside the sales order service -----");
        System.out.println();
        SalesOrder salesOrder = new SalesOrder();

        salesOrder.setPrice(Price);
        salesOrder.setEmail(Email);
        salesOrder.setDescription(Description);
        salesOrder.setDate(Date);

        System.out.println("---salesOrder -----" + salesOrder);
        return this.salesOrderRepository.save(salesOrder);


    }

//    public Item get(String item) {
//
//        System.out.println("----Coming inside the service----");
//        System.out.println("item is ----> " + item);
//        Item optional = itemRepository.findItemByName(item);
//
//        System.out.println(optional);
//        System.out.println("itemRepository.findItemByName(item) -> " + itemRepository.findItemByName(item));
//
//        Item result = null;
//        if (optional != null) {
//            result = (Item) optional;
//        }
//        return result;
//
//    }

//    public Customer modify(Customer customer) {
//
//        return customerRepository.save(customer);
//    }
//
//    public boolean delete(Customer customer) {
//
//        customerRepository.delete(customer);
//        return true;
//    }

//    public List<Item> getAll() {
//
//        return (List<Item>) itemRepository.findAll();
//    }

}
