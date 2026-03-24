package za.ac.cput.domain;
/*
AnimeStore.java
OrderItem class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 23 March 2026
*/

import java.util.UUID;

public class OrderItem extends Order {
   private String orderItemId;
   private String itemDescription;
   private int itemQuantity;
   private double unitPrice;

   private OrderItem(){}
    public OrderItem(String orderId, String orderDate, double orderTotalAmount, String status, String orderItemId,
                     String itemDescription, int itemQuantity, double unitPrice) {
        super(orderId, orderDate, orderTotalAmount, status);
        this.orderItemId = orderItemId;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.unitPrice = unitPrice;
    }


    public String getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(String orderItemId) {
       this.orderItemId = orderItemId;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", itemName='" + itemDescription + '\'' +
                ", itemQuantity=" + itemQuantity +'\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
public static  class Builder{
    private String orderItemId;
    private String itemDescription;
    private int itemQuantity;
    private double unitPrice;
    private String orderId;
    private String orderDate;
    private double orderTotalAmount;
    private String status;

    public Builder orderItemId(){
        this.orderItemId = orderItemId;
        return this;
    }
    public Builder itemDescription(){
        this.itemDescription = itemDescription;
        return this;
    }
    public Builder itemQuantity(){
        this.itemQuantity = itemQuantity;
        return this;
    }
    public Builder unitPrice(){
        this.unitPrice = unitPrice;
        return this;
    }
    public OrderItem build(){
        return new OrderItem(orderId, orderDate, orderTotalAmount, status,orderItemId,itemDescription,itemQuantity,unitPrice);
    }
    public static Builder builder() {
        return new Builder();
    }
    }
}


