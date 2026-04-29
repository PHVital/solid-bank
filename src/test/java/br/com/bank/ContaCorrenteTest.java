package br.com.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {
    private ContaCorrente contaCorrente;

    @Test
    void deveLancarExcecaoQuandoSaqueForMaiorQueSaldo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> contaCorrente.saque(50));
    }
}
