package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository repository;

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Optional<Order> read(String id) {
        return repository.findById(id);
    }

    @Override
    public Order update(Order order) {
        if (repository.existsById(order.getOrderId())) {
            return repository.save(order);
        }

        return null;
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        return getAll();
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Order> getOrdersByOrderId(String orderId) {
        List<Order> orders = repository.findAll();
        List<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                result.add(order);
            }
        }

        return result;
    }

    @Override
    public List<Order> getOrdersByStatus(String status) {
        List<Order> orders = repository.findAll();
        List<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getStatus().equals(status)) {
                result.add(order);
            }
        }

        return result;
    }
}