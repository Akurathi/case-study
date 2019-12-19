package com.example.item.repository;

import com.example.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerByEmail(String email);
}

//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//
////    Customer findByEmailAddress(String emailAddress);
//}
