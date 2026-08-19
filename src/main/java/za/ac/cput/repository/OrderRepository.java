package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository implements IRepository<Order, String> {

    private List<Order> orders = new ArrayList<>();

    @Override
    public Order create(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> read(String id) {
        for (Order o : orders) {
            if (o.getOrderId().equals(id)) {
                return Optional.of(o);
            }
        }
        return Optional.empty();
    }

    @Override
    public Order update(Order order) {
        Optional<Order> old = read(order.getOrderId());
        if (old.isPresent()) {
            orders.remove(old.get());
            orders.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Optional<Order> o = read(id);
        if (o.isPresent()) {
            orders.remove(o.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }
}
