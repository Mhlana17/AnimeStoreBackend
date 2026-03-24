package za.ac.cput.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private IProductRepository repository;
    private Product product1,product2;

    @BeforeEach
    void setUp() {
        repository = ProductRepository.getRepository();
        product1 = ProductFactory.createProduct( 49L,"Socks",29.00);
        product2 = ProductFactory.createProduct(50L, "Hat", 19.99);
    }


    @Test
    void create() {
        assertNotNull(product1);

        Product created = repository.create(product1);

        assertNotNull(created);
        assertEquals(product1.getProductId(), created.getProductId());

        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        repository.create(product1);

        Product read = repository.read(product1.getProductId());

        assertNotNull(read);
        assertEquals(product1.getProductId(), read.getProductId());

        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(product1);

        Product updatedProduct = new Product.Builder()
                .copy(product1)
                .setProductName("Shoes")
                .setProductPrice(99.99)
                .build();

        Product updated = repository.update(updatedProduct);

        assertNotNull(updated);
        assertEquals("Shoes", updated.getProductName());
        assertEquals(99.99, updated.getProductPrice());

        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        repository.create(product1);
        boolean deleted = repository.delete(product1.getProductId());

        assertTrue(deleted);

        Product read = repository.read(product1.getProductId());
        assertNull(read);

        System.out.println("Deleted successfully");
    }

    @Test
    void getAll() {
        repository.create(product1);

        repository.create(product2);

        assertEquals(2, repository.getAll().size());

        System.out.println("All Products: " + repository.getAll());

    }
}