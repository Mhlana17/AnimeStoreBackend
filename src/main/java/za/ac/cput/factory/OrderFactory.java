package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

/*
AnimeStore.java
OrderFactory class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 24 March 2026
*/

public class OrderFactory {

    public static Order createOrder(String orderId, String orderDate,
                                    double orderTotalAmount, String status) {

        // Input validation
        if (Helper.isNullOrEmpty(orderId) ||
                Helper.isNullOrEmpty(orderDate) ||
                Helper.isNullOrEmpty(status)) {
            return null;
        }

        if (orderTotalAmount <= 0) {
            return null;
        }

        // Validate status (optional - add valid statuses)
        String validStatus = validateStatus(status);
        if (validStatus == null) {
            return null;
        }

        return new Order(orderId, orderDate, orderTotalAmount, validStatus);
    }

    private static String validateStatus(String status) {
        // Define valid order statuses
        String[] validStatuses = {"pending", "shipped", "delivered", "cancelled"};

        for (String validStatus : validStatuses) {
            if (validStatus.equalsIgnoreCase(status)) {
                return validStatus.toLowerCase();
            }
        }
        return null;
    }
}