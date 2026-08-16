package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

public class OrderItemFactory {
    public static OrderItem createOrderItem(String orderItemId,
                                            String iteDescription,
                                            int itemQuantity,
                                            double unitPrice) {

        if (Helper.isNullOrEmpty(orderItemId) ||
                Helper.isNullOrEmpty(iteDescription) ||
                !Helper.isValidQuantity(itemQuantity) ||
                !Helper.isValidPrice(unitPrice)||
                orderItemId.isEmpty()) {
            return null;
        }
        return new OrderItem.Builder()
                .setOrderItemId(orderItemId)
                .setItemDescription(iteDescription)
                .setItemQuantity(itemQuantity)
                .setUnitPrice(unitPrice)
                .build();
    }
}