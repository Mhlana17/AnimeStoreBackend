package za.ac.cput.repository;
/*
AnimeStore.java
ProductRepository class
Author: Sisonke Mhlana(221805486)
Date: 24 March 2026
*/

import za.ac.cput.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static IProductRepository repository = null;
    private List<Product> productList;


    private ProductRepository(){
        productList = new ArrayList<>();
    }

    public static  IProductRepository getRepository(){

        if (repository == null){
            repository = new ProductRepository();
        }
        return repository;
    }


    @Override
    public Product create(Product product) {
        boolean success = productList.add(product);
        if (success){
            return product;
        }
        return null;
    }

    @Override
    public Product read(Long productId) {
       for (Product product : productList){
           if (product.getProductId().equals(productId)){
               return product;
           }
       }
       return null;
    }

    @Override
    public Product update(Product product) {
        Long id = product.getProductId();
        Product oldProduct = read(id);
        if (oldProduct == null) {
            return null;
        }
        boolean success = productList.remove(oldProduct);
        if(!success) {
            return null;
        }
        if (productList.add(product)) {
            return product;
        }
        return null;
    }

    @Override
    public boolean delete(Long productId) {
        Product productToDelete = read(productId);
        if (productToDelete == null){
            return false;
        }
        return (productList.remove(productToDelete));
    }
    @Override
    public List<Product> getAll() {
        return productList;
    }
}
