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
import java.util.Optional;

public class ProductRepository implements IProductRepository {

    private static IProductRepository repository = null;
    private List<Product> productList;

    private ProductRepository() {
        productList = new ArrayList<>();
    }

    public static IProductRepository getRepository() {

        if (repository == null) {
            repository = new ProductRepository();
        }

        return repository;
    }

    @Override
    public Product create(Product product) {
        boolean success = productList.add(product);

        if (success) {
            return product;
        }

        return null;
    }

    @Override
    public Optional<Product> read(Long productId) {
        for (Product product : productList) {
            if (product.getProductId().equals(productId)) {
                return Optional.of(product);
            }
        }

        return Optional.empty();
    }

    @Override
    public Product update(Product product) {
        Long id = product.getProductId();

        Optional<Product> oldProduct = read(id);

        if (oldProduct.isEmpty()) {
            return null;
        }

        boolean success = productList.remove(oldProduct.get());

        if (!success) {
            return null;
        }

        if (productList.add(product)) {
            return product;
        }

        return null;
    }

    @Override
    public boolean delete(Long productId) {
        Optional<Product> productToDelete = read(productId);

        if (productToDelete.isEmpty()) {
            return false;
        }

        return productList.remove(productToDelete.get());
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }
}