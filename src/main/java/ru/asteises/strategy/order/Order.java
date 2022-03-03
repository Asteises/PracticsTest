package ru.asteises.strategy.order;

import ru.asteises.strategy.pay.PaymentMethod;

import java.io.IOException;

public class Order {
    private double priceOrder = 0;

    public Order() {
    }

    public void setPriceOrder(double priceOrder) {
        this.priceOrder =+ priceOrder;
    }

    public void createOrder(PaymentMethod paymentMethod) throws IOException {
        if (paymentMethod.verify()) {
            paymentMethod.pay(priceOrder);
        }
    }
}
