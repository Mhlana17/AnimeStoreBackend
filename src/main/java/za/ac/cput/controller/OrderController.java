package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.service.IOrderService;
import za.ac.cput.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    // CREATE - POST
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order createdOrder = orderService.create(order);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ - GET by ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") String orderId) {
        Optional<Order> orderOpt = orderService.read(orderId);
        if (orderOpt.isPresent()) {
            return new ResponseEntity<>(orderOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE - PUT
    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        try {
            Order updatedOrder = orderService.update(order);
            if (updatedOrder != null) {
                return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE - DELETE
    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId") String orderId) {
        try {
            boolean deleted = orderService.delete(orderId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET BY STATUS
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Order>> getOrdersByStatus(@PathVariable("status") String status) {
        try {
            List<Order> orders = orderService.getOrdersByStatus(status);
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}