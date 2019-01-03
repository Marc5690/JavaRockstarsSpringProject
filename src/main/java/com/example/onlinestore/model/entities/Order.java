package com.example.onlinestore.model.entities;

import com.example.onlinestore.model.OrderStatus;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table") // Need this as ORDER is a reserved word in SQL.
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /* Automatically creates join table with two Foreign Key columns. However, if more columns are needed on
    // the join table then that requires two bidirectional @OneToMany associations.
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "order_product",
            joinColumns = { @JoinColumn(name = "order_id") }, // owning side
            inverseJoinColumns = { @JoinColumn(name = "product_id") } // inverse side
    )
    private Set<Product> products;*/

    // We do require more columns on the join table so this is one of the two bidirectional @OneToMany associations.
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private Date date;

    public Order(){}

    public Order(Customer customer, OrderStatus status, Date date) {
        this.customer = customer;
        this.status = status;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderProducts=" + orderProducts.toString() +
                ", status=" + status +
                ", date=" + date +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

