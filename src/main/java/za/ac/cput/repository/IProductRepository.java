package za.ac.cput.repository;
/*
AnimeStore.java
IProductRepository class
Author: Sisonke Mhlana(221805486)
Date: 24 March 2026
*/

import za.ac.cput.domain.Product;
import java.util.List;

public interface IProductRepository extends IRepository<Product, Long>  {
    List<Product> getAll();

}
