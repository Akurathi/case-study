package com.example.salesorderservice.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;


@Data
@Entity(name = "OrderLineItem")
@Table(name = "orderlineitem")
public class OrderLineItem {
    //Order Description, Order Date, Customer email id, list of item names

    //id, item_name, quantity, order_id

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;

//    private int quantity;

    private Long orderId;

}
