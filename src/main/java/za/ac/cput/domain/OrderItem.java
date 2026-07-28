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

    public OrderItem(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.itemDescription = builder.itemDescription;
        this.itemQuantity = builder.itemQuantity;
        this.unitPrice = builder.unitPrice;
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

        public Builder setOrderItemId(){
            this.orderItemId =orderItemId;
            return this;
        }

        public Builder setItemDescription(String itemDescription){
            this.itemDescription = itemDescription;
            return this;
        }

        public Builder setItemQuantity(int itemQuantity){
            this.itemQuantity = itemQuantity;
            return this;
        }

        public Builder setUnitPrice(double unitPrice){
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder setOrderId(String orderId){
            this.orderId = orderId;
            return this;
        }

        public Builder setOrderDate(String orderDate){
            this.orderDate = orderDate;
            return this;
        }

        public Builder setOrderTotalAmount(double amount){
            this.orderTotalAmount = amount;
            return this;
        }

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }
        public Builder copy(OrderItem orderItem){
            this.orderItemId = orderItem.getOrderItemId();
            this.itemDescription = orderItem.getItemDescription();
            this.itemQuantity = orderItem.getQuantity();
            this.unitPrice = orderItem.getUnitPrice();
            return this;
        }


        public OrderItem build(){

            return new OrderItem(this);
        }
    }
    }


