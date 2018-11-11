package com.example.onlinestore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Long> {

    List<Basket> findById(int id);
}

