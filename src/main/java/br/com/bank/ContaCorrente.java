package br.com.bank;

public class ContaCorrente {
    private int id;
    private double saldo;
    private String titular;

    public ContaCorrente(int id, double saldo, String titular) {
        this.id = id;
        this.saldo = 0;
        this.titular = titular;
    }

    public void deposito(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido");
            return;
        }
        this.saldo += valor;
    }

    public void saque(double valor) {
        if (saldo < valor) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= valor;
    }
}
