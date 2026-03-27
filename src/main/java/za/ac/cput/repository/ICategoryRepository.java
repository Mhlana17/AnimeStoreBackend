package za.ac.cput.repository;

import za.ac.cput.domain.Category;
import java.util.List;

/*
 * ICategoryRepository.java
 * Author: Mbasa Mcakumba (241080371)
 */
public interface ICategoryRepository {
    Category create(Category category);
    Category read(String id);
    Category update(Category category);
    boolean delete(String id);
    List<Category> getAll();
}