package com.example.onlinestore.model.repositories;

import com.example.onlinestore.model.entities.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByName(String name);
}
