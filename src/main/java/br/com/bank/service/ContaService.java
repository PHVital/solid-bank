package br.com.bank.service;

import br.com.bank.ContaCorrente;
import br.com.bank.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void realizarSaque(int id, double valor) {
        ContaCorrente conta = consultarConta(id);
        conta.saque(valor);
        contaRepository.save(conta);
    }

    public void realizarDeposito(int id, double valor) {
        ContaCorrente conta = consultarConta(id);
        conta.deposito(valor);
        contaRepository.save(conta);
    }

    public ContaCorrente consultarConta(int id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }
}
