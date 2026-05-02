package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderRepositoryTest {

    private static OrderRepository repo;
    private static Order order;

    @BeforeAll
    static void setup() {
        repo = new OrderRepository();
        order = OrderFactory.createOrder(
                "ORD001",
                "2026-03-23",
                500.0,
                "PAID",
                null
        );
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void testCreate() {
        assertNotNull(repo.create(order));
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void testRead() {
        assertNotNull(repo.read(order.getOrderId()));
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void testUpdate() {
        Order updated = new Order.Builder()
                .copy(order)
                .setStatus("SHIPPED")
                .build();

        Order result = repo.update(updated);
        assertEquals("SHIPPED", result.getStatus());
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void testGetAll() {
        assertFalse(repo.getAll().isEmpty());
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    void testDelete() {
        assertTrue(repo.delete(order.getOrderId()));
    }
}