package za.ac.cput.domain;
/*
AnimeStore.java
OrderItem class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 23 March 2026
*/

public class OrderItem extends Order {
   private String orderItemId;
   private String itemDescription;
   private int itemQuantity;
   private double unitPrice;

   private OrderItem(){

    }
    public OrderItem(String orderItemId,String itemDescription, int itemQuantity, double unitPrice) {
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
}
