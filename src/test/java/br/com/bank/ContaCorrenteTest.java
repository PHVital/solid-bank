package br.com.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {
    private ContaCorrente contaCorrente;

    @BeforeEach
    void setUp() {
        contaCorrente = new ContaCorrente(1, "Pedro Henrique");
    }

    @Test
    void deveLancarExcecaoQuandoSaqueForMaiorQueSaldo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrente.saque(50));
    }

    @Test
    void deveAumentarOSaldoQuandoDepositoForValido() {
        double oldSaldo = contaCorrente.getSaldo();
        contaCorrente.deposito(100);
        Assertions.assertEquals(100.00, contaCorrente.getSaldo());
    }

    @Test
    void deveLancarExcecaoQuandoDepositoForZeroOuNegativo() {
        Assertions.assertAll("Grouped Assertions of Deposito",
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrente.deposito(0)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrente.deposito(-10))
        );
    }

    @Test
    void deveDiminuirOSaldoQuandoSaqueForValido() {
        contaCorrente.deposito(100);
        contaCorrente.saque(20);
        Assertions.assertEquals(80.00, contaCorrente.getSaldo());
    }
}
