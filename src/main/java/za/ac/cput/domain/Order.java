package za.ac.cput.domain;
/*
AnimeStore.java
Order class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 23 March 2026
*/
public class Order {
    private String orderId;
    private String itemDate;
    private double amount;
    private String status;

    private Order(){

    }

    public Order(String orderId, String itemDate, double amount, String status) {
        this.orderId = orderId;
    }
}
