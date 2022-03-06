package ru.asteises.strategy;

import ru.asteises.strategy.order.Order;
import ru.asteises.strategy.pay.Card;
import ru.asteises.strategy.pay.PayPal;
import ru.asteises.strategy.pay.PaymentMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    static Map<Integer, Integer> products = new HashMap<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static Order order = new Order();
    static Factory factory = new Factory();

    static {
        products.put(1, 10);
        products.put(2, 20);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("Goods: ");
            System.out.println("1 - good 1");
            System.out.println("2 - good 2");
            System.out.println("0 - exit");
            int number = Integer.parseInt(bf.readLine());
            if (number == 0) {
                break;
            } else {
                order.setPriceOrder(products.get(number));
            }
        }
        System.out.println("PaymentMethod: ");
        System.out.println("1 - Card");
        System.out.println("2 - PayPal");
        int number = Integer.parseInt(bf.readLine());
        order.createOrder(factory.getMethod(number));
    }
}
