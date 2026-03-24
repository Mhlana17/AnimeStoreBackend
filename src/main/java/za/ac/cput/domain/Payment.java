package za.ac.cput.domain;

public class Payment {
    private String paymentId;
    private String orderId;
    private String method;
    private double amount;
    private String status;

    // Private constructor that takes a Builder
    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.orderId = builder.orderId;
        this.method = builder.method;
        this.amount = builder.amount;
        this.status = builder.status;
    }

    // Static inner Builder class
    public static class Builder {
        private String paymentId;
        private String orderId;
        private String method;
        private double amount;
        private String status;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Payment build() {
            return new Payment(this);
        }

    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", method='" + method + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}

