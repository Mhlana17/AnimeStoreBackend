package za.ac.cput.factory;

/*
AnimeStore.java
OrderFactoryTest class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 24 March 2026
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryTest {
    private Order order, order1, invalidOrder;

    @BeforeEach
    void setUp() {
        // Valid test data
        order = OrderFactory.createOrder("88855",
                "20 Feb 2026", 5400.00, "pending");
        order1 = OrderFactory.createOrder("88856",
                "21 Feb 2026", 3200.00, "shipped");
    }

    @Test
    void testCreateOrder() {
        assertNotNull(order);
        System.out.println(order.toString());
    }

    @Test
    void testCreateOrder1() {
        assertNotNull(order1);
        System.out.println(order1.toString());
    }

    @Test
    void testCreateOrderWithNullOrderId() {
        invalidOrder = OrderFactory.createOrder(null, "20 Feb 2026", 5400.00, "pending");
        assertNull(invalidOrder);
        System.out.println("Test passed: Null order ID returns null");
    }

    @Test
    void testCreateOrderWithEmptyOrderId() {
        invalidOrder = OrderFactory.createOrder("", "20 Feb 2026", 5400.00, "pending");
        assertNull(invalidOrder);
        System.out.println("Test passed: Empty order ID returns null");
    }

    @Test
    void testCreateOrderWithInvalidAmount() {
        invalidOrder = OrderFactory.createOrder("88857", "20 Feb 2026", -100.00, "pending");
        assertNull(invalidOrder);
        System.out.println("Test passed: Negative amount returns null");
    }

    @Test
    void testCreateOrderWithZeroAmount() {
        invalidOrder = OrderFactory.createOrder("88857", "20 Feb 2026", 0.00, "pending");
        assertNull(invalidOrder);
        System.out.println("Test passed: Zero amount returns null");
    }

    @Test
    void testCreateOrderWithInvalidStatus() {
        invalidOrder = OrderFactory.createOrder("88857", "20 Feb 2026", 5400.00, "invalid_status");
        assertNull(invalidOrder);
        System.out.println("Test passed: Invalid status returns null");
    }

    @Test
    void testCreateOrderWithNullStatus() {
        invalidOrder = OrderFactory.createOrder("88857", "20 Feb 2026", 5400.00, null);
        assertNull(invalidOrder);
        System.out.println("Test passed: Null status returns null");
    }

    @Test
    void testCreateOrderWithNullDate() {
        invalidOrder = OrderFactory.createOrder("88857", null, 5400.00, "pending");
        assertNull(invalidOrder);
        System.out.println("Test passed: Null date returns null");
    }

    @Test
    void testCreateOrderWithEmptyDate() {
        invalidOrder = OrderFactory.createOrder("88857", "", 5400.00, "pending");
        assertNull(invalidOrder);
        System.out.println("Test passed: Empty date returns null");
    }

    @Test
    void testCreateOrderWithDifferentStatuses() {
        Order pendingOrder = OrderFactory.createOrder("88858", "22 Feb 2026", 100.00, "PENDING");
        assertNotNull(pendingOrder);
        assertEquals("pending", pendingOrder.getStatus());

        Order shippedOrder = OrderFactory.createOrder("88859", "23 Feb 2026", 200.00, "SHIPPED");
        assertNotNull(shippedOrder);
        assertEquals("shipped", shippedOrder.getStatus());

        System.out.println("Test passed: Status case insensitivity works");
    }
}