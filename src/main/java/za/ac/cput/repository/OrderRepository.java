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
        for (Order order : orders) {
            if (order.getOrderId().equals(id)) {
                return Optional.of(order);
            }
        }

        return Optional.empty();
    }

    @Override
    public Order update(Order order) {
        Optional<Order> oldOrder = read(order.getOrderId());

        if (oldOrder.isPresent()) {
            orders.remove(oldOrder.get());
            orders.add(order);
            return order;
        }

        return null;
    }

    @Override
    public boolean delete(String id) {
        Optional<Order> order = read(id);

        if (order.isPresent()) {
            orders.remove(order.get());
            return true;
        }

        return false;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }
}