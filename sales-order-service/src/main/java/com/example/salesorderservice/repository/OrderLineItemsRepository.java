package com.example.salesorderservice.repository;

import com.example.salesorderservice.model.OrderLineItem;

import org.springframework.data.repository.CrudRepository;

public interface OrderLineItemsRepository extends CrudRepository<OrderLineItem, Long> {
}
