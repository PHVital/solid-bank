package br.com.bank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double saldo;
    private String titular;

    public ContaCorrente(int id, String titular) {
        this.id = id;
        this.saldo = 0;
        this.titular = titular;
    }

    public ContaCorrente() {}

    public void deposito(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
        this.saldo += valor;
    }

    public void saque(double valor) {
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}
