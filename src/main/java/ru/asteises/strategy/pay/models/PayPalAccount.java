package ru.asteises.strategy.pay.models;

public class PayPalAccount {
    private String email;
    private String password;
    private double sum;

    public PayPalAccount(String email, String password, double sum) {
        this.email = email;
        this.password = password;
        this.sum = sum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
