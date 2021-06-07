package com.mycompany.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mycompany.store.domain.enumeration.OrderItemStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A OrderItem.
 */
@Table("order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull(message = "must not be null")
    @Min(value = 0)
    @Column("quantity")
    private Integer quantity;

    @NotNull(message = "must not be null")
    @DecimalMin(value = "0")
    @Column("total_price")
    private BigDecimal totalPrice;

    @NotNull(message = "must not be null")
    @Column("status")
    private OrderItemStatus status;

    @JsonIgnoreProperties(value = { "productCategory" }, allowSetters = true)
    @Transient
    private Product product;

    @Column("product_id")
    private Long productId;

    @JsonIgnoreProperties(value = { "orderItems", "customer" }, allowSetters = true)
    @Transient
    private ProductOrder order;

    @Column("order_id")
    private Long orderId;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderItem id(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public OrderItem quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public OrderItem totalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice != null ? totalPrice.stripTrailingZeros() : null;
        return this;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice != null ? totalPrice.stripTrailingZeros() : null;
    }

    public OrderItemStatus getStatus() {
        return this.status;
    }

    public OrderItem status(OrderItemStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }

    public Product getProduct() {
        return this.product;
    }

    public OrderItem product(Product product) {
        this.setProduct(product);
        this.productId = product != null ? product.getId() : null;
        return this;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.productId = product != null ? product.getId() : null;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long product) {
        this.productId = product;
    }

    public ProductOrder getOrder() {
        return this.order;
    }

    public OrderItem order(ProductOrder productOrder) {
        this.setOrder(productOrder);
        this.orderId = productOrder != null ? productOrder.getId() : null;
        return this;
    }

    public void setOrder(ProductOrder productOrder) {
        this.order = productOrder;
        this.orderId = productOrder != null ? productOrder.getId() : null;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Long productOrder) {
        this.orderId = productOrder;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderItem)) {
            return false;
        }
        return id != null && id.equals(((OrderItem) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OrderItem{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", totalPrice=" + getTotalPrice() +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
