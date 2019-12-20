package com.example.item.service;



import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;


@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    public Item add(Item customer) {

        return itemRepository.save(customer);
    }

    public Item get(String item) {

        Item optional = itemRepository.findItemByName(item);
        System.out.println("----Coming inside the service----");
        System.out.println(optional);

        Item result = null;
        if (optional != null) {
            result = (Item) optional;
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

    public List<Item> getAll() {

        return (List<Item>) itemRepository.findAll();
    }

}
