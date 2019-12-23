package com.example.salesorderservice.repository;


import com.example.salesorderservice.model.SalesOrder;
import org.springframework.data.repository.CrudRepository;

//import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {

    //Customer findCustomerByEmail(String email);

//    Item findItemByName(String name);
//    Item findAllByName(String Name);
}

//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//
////    Customer findByEmailAddress(String emailAddress);
//}
