package com.example.salesorderservice.controller;


import com.example.salesorderservice.model.*;
import com.example.salesorderservice.service.CustomerServiceProxy;
import com.example.salesorderservice.service.ItemServiceProxy;
import com.example.salesorderservice.service.OrderLineItemService;
import com.example.salesorderservice.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("salesOrderController")
public class SalesOrderController {

    private SalesOrderService salesOrderService;
    private OrderLineItemService orderLineItemService;
    private static final Logger LOG = Logger.getLogger(SalesOrderController.class.getName());

    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @Autowired
    private ItemServiceProxy itemServiceProxy;

    public SalesOrderController(SalesOrderService salesOrderService, OrderLineItemService orderLineItemService) {

        this.salesOrderService = salesOrderService;
        this.orderLineItemService = orderLineItemService;
    }

    @PostMapping(value = "orders", produces = "application/json")
    public Long createOrder(@RequestBody customDetails orderDetails) {

        LOG.log(Level.INFO, "You reached create order method");

        System.out.println("----Coming inside the controller---create order---------------------");

        System.out.println("--- Checking Email is valid or not ----" + customerServiceProxy.getByEmail(orderDetails.getEmail()));

        Customer isCustomerAvailable = null;
        boolean customerEmailAvailable = false;
        isCustomerAvailable = customerServiceProxy.getByEmail(orderDetails.getEmail());
        if (isCustomerAvailable != null)
            customerEmailAvailable = true;

        List<Long> orderIdsList = new ArrayList<>();

        Long orderIdCreated = null;

        HashMap<String, Integer> hmap = new HashMap<>();

        if (customerEmailAvailable) {
            List<String> orderList = orderDetails.getItemNames();
            List<String> availableList = new ArrayList<>();

            double totalPrice = 0.0;
            for (String order : orderList) {
                Item item = null;
                item = itemServiceProxy.get(order);
                System.out.println("---Item Details ----" + item);

                if (item == null)
                    break;
                else {
                    totalPrice = totalPrice + item.getPrice();
                    availableList.add(item.getName());
                    if(hmap.containsKey(item.getName()))
                    {
                        int prev = hmap.get(item.getName());
                        prev++;
                        hmap.put(item.getName(), prev);
                    }
                    else
                    {
                        hmap.put(item.getName(), 1);
                    }
                }
            }
            SalesOrder salesRes = null;

            if(totalPrice == 0.0)
                return null;
            else
                salesRes = this.salesOrderService.add(orderDetails.getDate(), orderDetails.getEmail(), orderDetails.getDescription(), totalPrice);


            for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
                System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
                OrderLineItem orderRes = this.orderLineItemService.add(entry.getKey(), salesRes.getId(), (int)entry.getValue());
            }
            orderIdCreated = salesRes.getId();
        }
        return orderIdCreated;
    }

    @GetMapping(value = "orderDetailsByEmail/{email}", produces = "application/json")
    public List<HashMap<String,Integer>> getOrderDetailsByEmail(@PathVariable String email){

        LOG.log(Level.INFO, "You reached order by email method");
        HashMap<String, Integer> hmap = new HashMap<>();
        List<HashMap<String,Integer>> finalList = new ArrayList<>();
        List<SalesOrder> orderIdIs = this.salesOrderService.getOrderIdByEmail(email);
        System.out.println("------orderIdIs---------" + orderIdIs);

        System.out.println("---Calling salesorder Service with orderId" );

        for (SalesOrder salesOrder: orderIdIs) {
             hmap = this.orderLineItemService.getOrdersById(salesOrder.getId());
             finalList.add(hmap);
        }
        return finalList;

    }
}



