package com.example.salesorderservice.controller;


import com.example.salesorderservice.model.*;
import com.example.salesorderservice.service.CustomerServiceProxy;
import com.example.salesorderservice.service.ItemServiceProxy;
import com.example.salesorderservice.service.OrderLineItemService;
import com.example.salesorderservice.service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("salesOrderController")
public class SalesOrderController {

    private SalesOrderService salesOrderService;
    private OrderLineItemService orderLineItemService;

    @Autowired
    private CustomerServiceProxy customerServiceProxy;

    @Autowired
    private ItemServiceProxy itemServiceProxy;

    public SalesOrderController(SalesOrderService salesOrderService, OrderLineItemService orderLineItemService) {

        this.salesOrderService = salesOrderService;
        this.orderLineItemService = orderLineItemService;
    }

    @PostMapping(value = "orders" , produces = "application/json")
    public List<Long> createOrder(@RequestBody customDetails orderDetails) {
        // customDetails SalesOrder
        System.out.println("----Coming inside the controller---create order---------------------");

        System.out.println("--- Checking Email is valid or not ----" + customerServiceProxy.getByEmail(orderDetails.getEmail()));

        Customer custm_exist = null;
        boolean customerEmailAvailable = false;
        custm_exist = customerServiceProxy.getByEmail(orderDetails.getEmail());
        if(custm_exist != null)
            customerEmailAvailable = true;

        List<Long> orderIdsList = new ArrayList<>();

        //HashMap<String, Integer> hmap = new HashMap<>();
        if(customerEmailAvailable)
        {
            List<String> orderList = orderDetails.getItemNames();

            for (String order: orderList) {
                Item item =  null;
                item = itemServiceProxy.get(order);
                System.out.println("---Item Details ----"+item);

                if(item == null)
                    break;
                else
                {
                    //hmap.put(item.getName(), (int) item.getPrice());
                    //sales_order – id, date, email_id, description, price

                    System.out.println("---SalesOrder Details ----" + this.salesOrderService.add(orderDetails.getDate(),orderDetails.getEmail(), orderDetails.getDescription(), item.getPrice()));
                    SalesOrder salesRes = this.salesOrderService.add(orderDetails.getDate(),orderDetails.getEmail(), orderDetails.getDescription(), item.getPrice());

                    //order_line_item – id, item_name, quantity, order_id

                    System.out.println("------salesRes-----" + salesRes);

                    System.out.println("-----Going to orderLine items ---------");

                    System.out.println("---output---" + this.orderLineItemService.add(item.getName(), salesRes.getId()));

                    OrderLineItem orderRes = this.orderLineItemService.add(item.getName(), salesRes.getId());

                    System.out.println("-----orderRes-----" + orderRes);

                    orderIdsList.add(salesRes.getId());

                }

            }
        }



        //return this.salesOrderService.add(order);
        return orderIdsList;
    }


//    @GetMapping(value = "items/{item}", produces = "application/json")
//    public Item get(@PathVariable("item") String item) {
//        System.out.println("----Coming inside the controller---get-");
//        System.out.println("item is ----> " + item);
//        return this.itemService.get(item);
//    }

//    @GetMapping(value = "getEmail", produces = "application/json")
//    public Customer get(@RequestBody final String email) {
//        System.out.println("----Coming inside the controller---get-");
//        System.out.println(email);
//        return this.customerService.get(email);
//    }


//    @GetMapping(value = "getAllItems" , produces = "application/json")
//    public List<Item> getAll() {
//        System.out.println("----Coming inside the controller---getAll-");
//        return this.itemService.getAll();
//    }



}
