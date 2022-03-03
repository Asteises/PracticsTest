package ru.asteises.strategy.pay;

import ru.asteises.strategy.pay.models.PayPalAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PayPal implements PaymentMethod {
    private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private List<PayPalAccount> payPalAccounts;
    private PayPalAccount account;
    private int indexAccount;

    public PayPal() {
        this.payPalAccounts = new ArrayList<>();
        payPalAccounts.add(new PayPalAccount("email@", "password", 1000.1));
    }

    @Override
    public boolean pay(double sum) {
        if (account.getSum() >= sum) {
            System.out.println("OK");
            account.setSum(account.getSum() - sum);
            payPalAccounts.set(indexAccount, account);
            return true;
        }
        System.out.println("NO MONEY");
        return false;
    }

    @Override
    public boolean verify() throws IOException {
        System.out.print("Enter email: ");
        String email = bf.readLine();
        System.out.print("Enter password: ");
        String password = bf.readLine();

        for (int i = 0; i < payPalAccounts.size(); i++) {
            if (payPalAccounts.get(i).getEmail().equals(email) && payPalAccounts.get(i).getPassword().equals(password)) {
                indexAccount = i;
                this.account = account;
                System.out.println("OK");
                return true;
            }
        }

        for (PayPalAccount account : payPalAccounts) {

        }
        System.out.println("Failed");
        return false;
    }
}
