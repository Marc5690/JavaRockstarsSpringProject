package com.example.onlinestore.model.repositories;

import com.example.onlinestore.model.OrderProductPK;
import com.example.onlinestore.model.OrderStatus;
import com.example.onlinestore.model.entities.Customer;
import com.example.onlinestore.model.entities.Order;
import com.example.onlinestore.model.entities.OrderProduct;
import com.example.onlinestore.model.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private TestEntityManager _entityManager;

    @Autowired
    private OrderRepository _orderRepository;

    private Order createAndPersistOrder() {
        Customer customer = new Customer("Test", "Customer");
        _entityManager.persist(customer);

        Product hat = new Product("Hat", new BigDecimal(20.00));
        Product shirt = new Product("Shirt", new BigDecimal(25.00));
        _entityManager.persist(hat);
        _entityManager.persist(shirt);

        Order order = new Order(customer, OrderStatus.PENDING, new Date());
        _entityManager.persist(order);

        OrderProductPK hatPK = new OrderProductPK(order.getId(), hat.getId());
        OrderProduct opHat = new OrderProduct(order, hat, hat.getPrice(), 1);
        opHat.setId(hatPK);
        _entityManager.persist(opHat);
        OrderProductPK shirtPK = new OrderProductPK(order.getId(), shirt.getId());
        OrderProduct opShirt = new OrderProduct(order, shirt, shirt.getPrice(), 2);
        opShirt.setId(shirtPK);
        _entityManager.persist(opShirt);
        hat.setOrderProducts(Arrays.asList(opHat));
        shirt.setOrderProducts(Arrays.asList(opShirt));
        order.setOrderProducts(Arrays.asList(opHat, opShirt));

        return order;
    }

    @Test
    public void testManyProductsCanBeStoredOnOrder() {
        Order order = createAndPersistOrder();

        Order resultOrder = _orderRepository.findById(order.getId()).get();

        assertThat(resultOrder).isNotNull();
        assertThat(resultOrder.getOrderProducts().size()).isEqualTo(2);
    }

}