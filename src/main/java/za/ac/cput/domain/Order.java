package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "total_amount")
    private double orderTotalAmount;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<OrderItem> orderItems;

    protected Order() {}

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.orderTotalAmount = builder.orderTotalAmount;
        this.status = builder.status;
        this.orderItems = builder.orderItems;
        // Set the relationship on each item
        if (this.orderItems != null) {
            for (OrderItem item : this.orderItems) {
                item.setOrder(this);
            }
        }
    }

    // Getters and setters...
    public String getOrderId() { return orderId; }
    public String getOrderDate() { return orderDate; }
    public double getOrderTotalAmount() { return orderTotalAmount; }
    public String getStatus() { return status; }
    public List<OrderItem> getOrderItems() { return orderItems; }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        if (orderItems != null) {
            for (OrderItem item : orderItems) {
                item.setOrder(this);
            }
        }
    }

    // Builder Class
    public static class Builder {
        private String orderId;
        private String orderDate;
        private double orderTotalAmount;
        private String status;
        private List<OrderItem> orderItems;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderTotalAmount(double orderTotalAmount) {
            this.orderTotalAmount = orderTotalAmount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder copy(Order order) {
            this.orderId = order.orderId;
            this.orderDate = order.orderDate;
            this.orderTotalAmount = order.orderTotalAmount;
            this.status = order.status;
            this.orderItems = order.orderItems;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}