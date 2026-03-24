package za.ac.cput.factory;
/*
AnimeStore.java
ProductFactory class
Author: Sisonke Mhlana(221805486)
Date: 24 March 2026
*/
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {

    public static Product createProduct(Long productId, String productName, Double productPrice ){
        if (Helper.isNullOrEmpty(productName)){
            System.out.println("Product name" + productName);
            return null;
        }
        if (!Helper.isValidId(productId)){
            System.out.println("Invalid product ID: " + productId);
            return null;
        }
        if (!Helper.isValidPrice(productPrice)){
            System.out.println("Invalid product price: " + productPrice);
            return null;
        }

        return new Product.Builder()
                .setProductId(productId)
                .setProductName(productName)
                .setProductPrice(productPrice)
                .build();

    }//end of create
}//end of class
