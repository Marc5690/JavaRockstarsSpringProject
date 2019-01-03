package com.example.onlinestore.model.repositories;

import java.util.List;

import com.example.onlinestore.model.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
