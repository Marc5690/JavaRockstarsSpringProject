package com.example.onlinestore.model.entities;

import com.example.onlinestore.model.OrderProductPK;
import javax.persistence.*;
import java.math.BigDecimal;
/**
 * This is a Join entity; the combination of the foreign keys will be its composite primary key.
 */
@Entity
@Table(name = "order_product")
public class OrderProduct {

    @EmbeddedId
    OrderProductPK id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private BigDecimal productPrice;

    @Column(nullable = false)
    private int productQuantity;

    public OrderProduct(Order order, Product product, BigDecimal productPrice, int productQuantity) {
        this.order = order;
        this.product = product;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public OrderProduct(){}

    public OrderProductPK getId() {
        return id;
    }

    public void setId(OrderProductPK id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

}
