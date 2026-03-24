package za.ac.cput.factory;

import za.ac.cput.domain.Payment;

public class PaymentFactory {
    public static Payment createPayment(String paymentId, String orderId, String method, double amount, String status){
       if (paymentId == null || paymentId.isEmpty()){
           throw new IllegalArgumentException("Payment ID is required");
       }
       if (orderId == null || orderId.isEmpty()){
           throw new IllegalArgumentException("Order ID is required");
       }
       if (method == null || method.isEmpty()){
           throw new IllegalArgumentException("Payment method is required");
       }
       if (amount < 0) {
           throw new IllegalArgumentException("Amount must be greater than 0");
       }
       if (status == null || status.isEmpty()){
           throw new IllegalArgumentException("Status is required");
       }

       return new Payment.Builder()
               .setPaymentId(paymentId)
               .setOrderId(orderId)
               .setMethod(method)
               .setAmount(amount)
               .setStatus(status)
               .build();
    }
}
