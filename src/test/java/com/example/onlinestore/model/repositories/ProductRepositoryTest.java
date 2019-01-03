package com.example.onlinestore.model.repositories;

import com.example.onlinestore.model.entities.Product;
import com.example.onlinestore.model.repositories.ProductRepository;
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
public class ProductRepositoryTest {
    @Autowired
    private TestEntityManager _entityManager;

    @Autowired
    private ProductRepository _productRepository;

    @Test
    public void testFindByName() {
        Product product = new Product("Shirt", new BigDecimal(20.00));
        _entityManager.persist(product);
        _entityManager.persist(new Product("Hat", new BigDecimal(15.00))); // Another product.

        List<Product> findByName = _productRepository.findByName(product.getName());

        assertThat(findByName).extracting(Product::getName).containsOnly(product.getName());
        assertThat(findByName).extracting(Product::getPrice).contains(product.getPrice());
    }

}