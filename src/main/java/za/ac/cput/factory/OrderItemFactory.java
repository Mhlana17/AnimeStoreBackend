package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderItemFactory {
    public static OrderItem createOrderItem(String orderItem,
                                            String iteDescription,
                                            int itemQuantity,
                                            double unitPrice) {

        if (Helper.isNullOrEmpty(orderItem) ||
                Helper.isNullOrEmpty(iteDescription) ||
                Helper.isValidName(itemQuantity) ||
                Helper.isValidPrice(unitPrice)||
                orderItem.isEmpty()) {
            return null;
        }
        return new OrderItem.Builder()
                .setOrderItemId(orderItem)
                .setItemDescription(iteDescription)
                .setItemQuantity(itemQuantity)
                .setUnitPrice(unitPrice)
                .build();
    }
}
