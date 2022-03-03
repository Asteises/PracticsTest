package ru.asteises.strategy.pay;

import java.io.IOException;

public interface PaymentMethod {
    boolean pay(double sum);
    boolean verify() throws IOException;
}
