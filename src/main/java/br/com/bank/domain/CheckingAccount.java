package br.com.bank.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CheckingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double balance;
    private String accountHolder;
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();

    public CheckingAccount(int id, String accountHolder) {
        this.id = id;
        this.balance = 0;
        this.accountHolder = accountHolder;
    }

    public CheckingAccount() {}

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        this.balance += amount;
    }

    public void withdrawal(double amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
