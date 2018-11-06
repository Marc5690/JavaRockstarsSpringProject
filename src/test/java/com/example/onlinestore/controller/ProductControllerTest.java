package com.example.onlinestore.controller;

import com.example.onlinestore.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductControllerTest {

    @Autowired
    private TestEntityManager _entityManager;

    private static final ProductController _productController = new ProductController();

    @Test
    public void testGetAllProducts() {
        /*Product product = new Product("Shirt", new BigDecimal(20));
        _entityManager.persist(product);
        _entityManager.persist(new Product("Hat", new BigDecimal(15))); // Another product.

        List<Product> allProducts = _productController.getAllProducts();

        assertThat(allProducts).isNotEmpty();*/
    }

}
