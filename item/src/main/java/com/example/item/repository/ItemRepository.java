package com.example.item.repository;


import com.example.item.model.Item;
import org.springframework.data.repository.CrudRepository;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

    //Customer findCustomerByEmail(String email);

    Item findItemByName(String name);
}

//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//
////    Customer findByEmailAddress(String emailAddress);
//}
