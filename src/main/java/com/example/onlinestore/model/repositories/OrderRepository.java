package com.example.onlinestore.model.repositories;

import com.example.onlinestore.model.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    // No custom queries needed.

}