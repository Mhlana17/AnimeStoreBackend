package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
    // JpaRepository already provides:
    // - save(Order order)
    // - findById(String id)
    // - findAll()
    // - deleteById(String id)
    // - existsById(String id)
    
    // Custom query methods (Spring Data JPA will implement these automatically)
    List<Order> findByStatus(String status);
    List<Order> findByOrderId(String orderId);
    List<Order> findByOrderDate(String orderDate);
}