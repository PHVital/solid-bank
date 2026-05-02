package br.com.bank.controller;

import br.com.bank.ContaCorrente;
import br.com.bank.service.ContaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {
    private ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ContaCorrente consultarConta(@RequestParam int id) {
        return contaService.consultarConta(id);
    }

    @PostMapping("/deposito")
    public String realizarDeposito(@RequestParam int id, @RequestParam double valor) {
        ContaCorrente conta = consultarConta(id);
        conta.deposito(valor);
        return "Depósito de R$ " + valor + " realizado com sucesso! Novo saldo: R$ " + conta.getSaldo();
    }

    @PostMapping("/saque")
    public String realizarSaque(@RequestParam int id, @RequestParam double valor) {
        ContaCorrente conta = consultarConta(id);
        conta.saque(valor);
        return "Saque de R$ " + valor + " realizado com sucesso! Novo saldo: R$ " + conta.getSaldo();
    }
}
