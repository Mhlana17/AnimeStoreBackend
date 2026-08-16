package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {

    @Test
    void createOrder() {
        List<OrderItem> items = new ArrayList<>();

        OrderItem item1 = new OrderItem.Builder()
                 .setOrderItemId("OI001")
                .setItemQuantity(2)
                .setUnitPrice(100.00)
                .build();
                items.add(item1);

                Order order = OrderFactory.createOrder("2255a","12/08/2026",
                        200.00,"pending", items);
                assertNotNull(order);
    }
}