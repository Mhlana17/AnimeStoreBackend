package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import za.ac.cput.domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {
    private Product product1;

    @BeforeEach
    void setUp() {

        product1 = ProductFactory.createProduct( 49L,"Socks",29.00);
    }
@Test
     void testCreateProduct(){
        assertNotNull(product1);
        System.out.println(product1.toString());
    }




}//end of class