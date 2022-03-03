package ru.asteises.strategy.pay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Card implements PaymentMethod {
    private int currentCard;
    private Map<Integer, Byte> cards;
    private Map<Integer, Double> cardBalance;
    private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public Card() {
        cards = new HashMap<>();
        cards.put(1234, (byte) 333);
        cardBalance = new HashMap<>();
        cardBalance.put(1234, 500.5);
    }

    @Override
    public boolean pay(double sum) {
        if (cardBalance.get(currentCard) >= sum) {
            System.out.println("OK");
            cardBalance.put(currentCard, cardBalance.get(currentCard) - sum);
            return true;
        } else {
            System.out.println("NO MONEY");
            return false;
        }
    }

    @Override
    public boolean verify() throws IOException {
        System.out.print("Enter card number: ");
        String cardNumber = bf.readLine();
        System.out.print("Enter svv code: ");
        String svvCode = bf.readLine();

        if (cards.get(cardNumber).equals(svvCode)) {
            System.out.println("Successes");
            currentCard = Integer.parseInt(cardNumber);
            return true;
        } else {
            System.out.println("Failed");
            return false;
        }
    }
}
