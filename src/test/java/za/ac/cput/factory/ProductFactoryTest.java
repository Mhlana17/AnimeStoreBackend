package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    private static Product product1 = ProductFactory.createProduct(23L,"hoody",499.00);
    private static Product product2 = ProductFactory.createProduct(24L,"hat", 120.00);
@Test
    public void testCreateProduct(){
        assertNotNull(product1);
        System.out.println(product1.toString());
    }

    public void testCreateProduct1(){
        assertNotNull(product2);
        System.out.println(product2.toString());
    }


}//end of class