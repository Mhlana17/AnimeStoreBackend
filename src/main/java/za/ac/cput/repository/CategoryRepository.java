package za.ac.cput.repository;

import za.ac.cput.domain.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static CategoryRepository repository = null;
    private List<Category> categoryList;

    private CategoryRepository() {
        categoryList = new ArrayList<>();
    }

    public static CategoryRepository getRepository() {
        if (repository == null) {
            repository = new CategoryRepository();
        }
        return repository;
    }

    @Override
    public Category create(Category category) {
        this.categoryList.add(category);
        return category;
    }

    @Override
    public Category read(String id) {
        for (Category c : categoryList) {
            if (c.getCategoryId().equals(id)) return c;
        }
        return null;
    }

    @Override
    public Category update(Category category) {
        Category oldCategory = read(category.getCategoryId());
        if (oldCategory != null) {
            categoryList.remove(oldCategory);
            categoryList.add(category);
            return category;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Category categoryToDelete = read(id);
        if (categoryToDelete != null) {
            return categoryList.remove(categoryToDelete);
        }
        return false;
    }

    @Override
    public List<Category> getAll() {
        return categoryList;
    }
}