package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IRepository<Order, String> {

    private List<Order> orders = new ArrayList<>();

    @Override
    public Order create(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order read(String id) {
        for (Order o : orders) {
            if (o.getOrderId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        Order old = read(order.getOrderId());
        if (old != null) {
            orders.remove(old);
            orders.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Order o = read(id);
        if (o != null) {
            orders.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }
}
