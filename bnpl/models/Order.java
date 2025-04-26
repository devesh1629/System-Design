package bnpl.models;

import java.time.LocalDate;

public class Order {

    Integer orderId;
    String productName;
    Integer quantity;
    Integer orderAmount;
    LocalDate orderDate;
    PaymentMethod paymentMethod;
    Boolean paymentCompleted;
    LocalDate paymentDate;

    public Order(Integer orderId, String productName, Integer quantity, Integer orderAmount, PaymentMethod paymentMethod, LocalDate date) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.orderAmount = orderAmount;
        this.paymentMethod = paymentMethod;
        paymentCompleted = paymentMethod.equals(PaymentMethod.Prepaid);
        this.orderDate = date;
        if(paymentMethod.equals(PaymentMethod.Prepaid))
            this.paymentDate = date;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getPaymentCompleted() {
        return paymentCompleted;
    }

    public void setPaymentCompleted(Boolean paymentCompleted) {
        this.paymentCompleted = paymentCompleted;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
}
