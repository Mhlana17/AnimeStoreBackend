package za.ac.cput.domain;
/*
AnimeStore.java
OrderItem class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 23 March 2026
*/


public class OrderItem {
   private String orderItemId;
   private String itemDescription;
   private int itemQuantity;
   private double unitPrice;

   private OrderItem(){}

    public OrderItem(String orderId, String orderDate, double orderTotalAmount, String status, String orderItemId,
                     String itemDescription, int itemQuantity, double unitPrice) {
        this.orderItemId = orderItemId;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.unitPrice = unitPrice;
    }


    public String getOrderItemId() {
        return orderItemId;
    }

    public int getQuantity() {
        return itemQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public static class Builder {
        private String orderItemId;
        private String itemDescription;
        private int itemQuantity;
        private double unitPrice;

        private String orderId;
        private String orderDate;
        private double orderTotalAmount;
        private String status;

        public Builder orderItemId(){
            this.orderItemId =orderItemId;
            return this;
        }

        public Builder itemDescription(String itemDescription){
            this.itemDescription = itemDescription;
            return this;
        }

        public Builder itemQuantity(int itemQuantity){
            this.itemQuantity = itemQuantity;
            return this;
        }

        public Builder unitPrice(double unitPrice){
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder orderId(String orderId){
            this.orderId = orderId;
            return this;
        }

        public Builder orderDate(String orderDate){
            this.orderDate = orderDate;
            return this;
        }

        public Builder orderTotalAmount(double amount){
            this.orderTotalAmount = amount;
            return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public OrderItem build(){
            return new OrderItem(
                    orderId,
                    orderDate,
                    orderTotalAmount,
                    status,
                    orderItemId,
                    itemDescription,
                    itemQuantity,
                    unitPrice
            );
        }

        public static Builder builder(){
            return new Builder();
        }

        public Builder copy(OrderItem orderItem){
            this.orderItemId = orderItem.getOrderItemId();
            this.itemDescription = orderItem.getItemDescription();
            this.itemQuantity = orderItem.getQuantity();
            this.unitPrice = orderItem.getUnitPrice();
            return this;
        }
    }
    }


