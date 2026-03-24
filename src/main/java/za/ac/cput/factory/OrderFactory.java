package za.ac.cput.factory;

import za.ac.cput.domain.Order;

/*
AnimeStore.java
Order class
Author: Vumbhoni Clifford Mnisi (222929456)
Date: 24 March 2026
*/

import java.util.HashMap;
import java.util.Map;

public class OrderFactory {

    private static Map<String, Order> orderRepository = new HashMap<>();

    public static Order createOrder(String orderId,String orderDate,double orderTotalAmount,String status){
        Order newOrder = new Order(orderId, orderDate, orderTotalAmount, status);
        orderRepository.put(orderId, newOrder);
        return newOrder;
    }
}
