package br.com.bank.controller;

import br.com.bank.ContaCorrente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaCorrente minhaConta = new ContaCorrente(1, "Pedro Henrique");

    @GetMapping
    public ContaCorrente consultarConta() {
        return minhaConta;
    }

    @PostMapping("/deposito")
    public String realizarDeposito(@RequestParam double valor) {
         minhaConta.deposito(valor);
         return "Depósito de R$ " + valor + " realizado com sucesso! Novo saldo: R$ " + minhaConta.getSaldo();
    }

    @PostMapping("/saque")
    public String realizarSaque(@RequestParam double valor) {
        minhaConta.saque(valor);
        return "Saque de R$ " + valor + " realizado com sucesso! Novo saldo: R$ " + minhaConta.getSaldo();
    }
}
