package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;
import static org.junit.jupiter.api.Assertions.*;

/*
 * CategoryRepositoryTest.java
 * Author: Mbasa Mcakumba (241080371)
 */
class CategoryRepositoryTest {
    private static CategoryRepository repository = CategoryRepository.getRepository();
    private Category category1;

    @BeforeEach
    void setUp() {
        category1 = CategoryFactory.buildCategory("HD-01", "Hoodies");
    }

    @Test
    void testCreate() {
        Category created = repository.create(category1);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void testRead() {
        repository.create(category1);
        Category read = repository.read(category1.getCategoryId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }
}