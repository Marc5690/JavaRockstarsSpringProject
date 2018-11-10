package com.example.onlinestore.controller;

import com.example.onlinestore.model.Product;
import com.example.onlinestore.model.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductControllerTest {

    @Autowired
    private TestEntityManager _entityManager;

    @MockBean
    private ProductRepository _productRepository;

    // Must do this TestConfiguration so ProductController can be Autowired and used in tests.
    @TestConfiguration
    static class ProductControllerTestContextConfiguration {
        @Bean
        public ProductController productController() {
            return new ProductController();
        }
    }

    @Autowired
    private ProductController _productController;

    @Test
    public void testGetAllProducts() {
        Product nonPersistedProduct = new Product("Shirt", new BigDecimal(20));
        // Notice that _productRepository was mocked already with @MockBean.
        Mockito.when(_productRepository.findAll()).thenReturn(Arrays.asList(nonPersistedProduct));

        List<Product> allProducts = _productController.getAllProducts();

        assertThat(allProducts).isNotEmpty();
        assertThat(allProducts.get(0).getName()).isEqualTo(nonPersistedProduct.getName());
        assertThat(allProducts.get(0).getPrice()).isEqualTo(nonPersistedProduct.getPrice());
    }

}
