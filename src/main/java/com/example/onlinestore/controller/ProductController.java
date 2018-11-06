package com.example.onlinestore.controller;

import java.util.List;
import com.example.onlinestore.model.Product;
import com.example.onlinestore.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ProductController {

    @Autowired // Tells the application context to inject an instance of ProductRepository here.
    private ProductRepository _productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        // Type casting works now, but the findAll method is only contracted to return Iterable, so it might not always be List.
        List<Product> allProducts = (List<Product>) _productRepository.findAll();

        return allProducts;
    }

}
