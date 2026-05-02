package za.ac.cput.domain;

import java.util.Arrays;

public class Order {
    private String orderId;
    private String orderDate;
    private double orderTotalAmount;
    private String status;
    private OrderItem[] orderItems;

    // Private constructor (Builder only)
    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.orderTotalAmount = builder.orderTotalAmount;
        this.status = builder.status;
        this.orderItems = builder.orderItems;
    }

    public String getOrderId() {
        return orderId;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public double getAmount() {
        return orderTotalAmount;
    }
    public String getStatus() {
        return status;
    }
    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTotalAmount=" + orderTotalAmount +
                ", status='" + status + '\'' +
                ", orderItems=" + Arrays.toString(orderItems) +
                '}';
    }

    // 🔨 BUILDER
    public static class Builder {
        private String orderId;
        private String orderDate;
        private double orderTotalAmount;
        private String status;
        private OrderItem[] orderItems;

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

        public Builder setOrderItems(OrderItem[] orderItems) {
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