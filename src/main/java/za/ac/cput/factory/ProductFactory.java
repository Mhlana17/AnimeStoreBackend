package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {

    public static Product createProduct(Long productId, String productName, Double productPrice ){
        if (!Helper.isValidId(productId)){
            System.out.println("Invalid product ID");
            return null;
        }
        if (!Helper.isNullOrEmpty(productName)){
            System.out.println("Invalid product name");
            return null;
        }
        if (!Helper.isValidPrice(productPrice)){
            System.out.println("Invalid product price");
            return null;
        }


          return new Product.Builder().setProductId(productId).setProductName(productName)
                  .setProductPrice(productPrice)
                  .build();


    }//end of create


}//end of class
