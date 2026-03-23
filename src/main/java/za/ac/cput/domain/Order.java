package za.ac.cput.domain;
/*
AnimeStore.java
Order class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 23 March 2026
*/
public class Order {
    private String orderId;
    private String orderDate;
    private double amount;
    private String status;

    public Order(){

    }

    public Order(String orderId, String orderDate, double amount, String status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.amount = amount;
        this.status = status;
    }
    public String getOrderId() {
        return orderId;
    }

    public String getOrderDateDate() {
        return orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }

}
