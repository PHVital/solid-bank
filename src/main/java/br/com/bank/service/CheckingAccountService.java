package br.com.bank.service;

import br.com.bank.domain.CheckingAccount;
import br.com.bank.repository.CheckingAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;
    private final TransactionService transactionService;

    public CheckingAccountService(CheckingAccountRepository checkingAccountRepository, TransactionService transactionService) {
        this.checkingAccountRepository = checkingAccountRepository;
        this.transactionService = transactionService;
    }

    @Transactional
    public void performWithdrawal(int id, double amount) {
        CheckingAccount account = getAccount(id);
        account.withdrawal(amount);
        checkingAccountRepository.save(account);
        transactionService.saveTransaction(amount, LocalDate.now(), "WITHDRAWAL", account);
    }

    @Transactional
    public void performDeposit(int id, double amount) {
        CheckingAccount account = getAccount(id);
        account.deposit(amount);
        checkingAccountRepository.save(account);
        transactionService.saveTransaction(amount, LocalDate.now(), "DEPOSIT", account);
    }

    public CheckingAccount getAccount(int id) {
        return checkingAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }
}
