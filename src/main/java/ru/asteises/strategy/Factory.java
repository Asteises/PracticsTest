package ru.asteises.strategy;

import ru.asteises.strategy.pay.Card;
import ru.asteises.strategy.pay.PayPal;
import ru.asteises.strategy.pay.PaymentMethod;

public class Factory {

    public PaymentMethod getMethod(int number) {
        if (number == 1) {
            return new Card();
        }
        if (number == 2) {
            return new PayPal();
        }
        return null;
    }
}
