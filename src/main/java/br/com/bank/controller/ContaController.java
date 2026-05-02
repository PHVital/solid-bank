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
        contaService.realizarDeposito(id, valor);
        ContaCorrente contaAtualizada = contaService.consultarConta(id);
        return "Depósito de R$ " + valor + " realizado com sucesso! Novo saldo: R$ " + contaAtualizada.getSaldo();
    }

    @PostMapping("/saque")
    public String realizarSaque(@RequestParam int id, @RequestParam double valor) {
        contaService.realizarSaque(id, valor);
        ContaCorrente contaAtualizada = contaService.consultarConta(id);
        return "Saque de R$ " + valor + " realizado com sucesso! Novo saldo: R$ " + contaAtualizada.getSaldo();
    }
}
