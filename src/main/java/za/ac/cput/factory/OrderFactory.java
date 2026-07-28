package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderFactory {

    public static Order createOrder(String orderId,
                                    String orderDate,
                                    Double amount,
                                    String status,
                                    OrderItem[] items) {


        if (Helper.isNullOrEmpty(orderId) ||
                Helper.isNullOrEmpty(orderDate) ||
                Helper.isNullOrEmpty(status) ||
                !Helper.isValidPrice(amount)) {
            return null;
        }

        return new Order.Builder()
                .setOrderId(orderId)
                .setOrderDate(orderDate)
                .setOrderTotalAmount(amount)
                .setStatus(status)
                .setOrderItems(items)
                .build();
    }
}