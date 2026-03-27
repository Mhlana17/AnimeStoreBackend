package za.ac.cput.domain;
/*
AnimeStore.java
Product class
Author: Sisonke Mhlana(221805486)
Date: 24 March 2026
*/

public class Product {
    private Long productId;
    private String productName;
    private Double productPrice;

    public Product(){


    }

    public Product(Builder builder){
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productPrice = builder.productPrice;

    }

    public Long getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public Double getProductPrice() {
        return productPrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    public static class Builder{
        private Long productId;
        private String productName;
        private Double productPrice;

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setProductPrice(Double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder copy(Product product){
            this.productId = product.productId;
            this.productName = product.productName;
            this.productPrice = product.productPrice;
            return this;

        }

        public Product build(){
            return new Product(this);
        }

    }

}//end of class
