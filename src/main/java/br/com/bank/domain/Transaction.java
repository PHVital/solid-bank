package br.com.bank.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private String type;
    private LocalDate dateTime;
    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private CheckingAccount account;

    public Transaction(double amount, LocalDate date, String type, CheckingAccount account) {
        this.amount = amount;
        this.dateTime = date;
        this.type = type;
        this.account = account;
    }

    public Transaction() {

    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }
}
