package com.example.item.service;


import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;


@Service
public class ItemService {

    private CustomerRepository customerRepository;

    public ItemService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    public Customer add(Customer customer) {

        return customerRepository.save(customer);
    }

    public Customer get(String emailId) {

        Customer optional = customerRepository.findCustomerByEmail(emailId);
        System.out.println("----Coming inside the service----");
        System.out.println(optional);

        Customer result = null;
        if (optional != null) {
            result = (Customer) optional;
        }
        return result;

    }

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

    public List<Customer> getAll() {

        return (List<Customer>) customerRepository.findAll();
    }

}
