package za.ac.cput.factory;

// Kyle Marais 222727993

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.PaymentMethod;
import za.ac.cput.domain.PaymentStatus;

public class PaymentFactory {
    public static Payment createPayment(String paymentId, String orderId, PaymentMethod method, double amount, PaymentStatus status) {
        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setOrderId(orderId)
                .setMethod(method)
                .setAmount(amount)
                .setStatus(status)
                .build();
    }
}
