package com.example.onlinestore.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * This class has a composite key and implements Serializable so it must override equals and hashCode.
 */

@Embeddable
public class OrderProductPK implements Serializable {

    @Column(name = "order_id")
    private long orderId;
    @Column(name = "product_id")
    private long productId;

    public OrderProductPK(long orderId, long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProductPK)) return false;
        OrderProductPK that = (OrderProductPK) o;
        return getOrderId() == that.getOrderId() &&
                getProductId() == that.getProductId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getProductId());
    }

}
