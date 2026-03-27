package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {
@Test
    void testCreateOrder(){
    Order orderFactory = OrderFactory.createOrder("88855",
            "20 Feb 2026",5400.00,"pending");
    assertNotNull(orderFactory);
    System.out.println(orderFactory);
}
}