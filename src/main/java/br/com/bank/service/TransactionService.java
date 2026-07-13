package br.com.bank.service;

import br.com.bank.domain.CheckingAccount;
import br.com.bank.domain.Transaction;
import br.com.bank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void saveTransaction(double amount, LocalDate date, String type, CheckingAccount account) {
        Transaction transaction = new Transaction(amount, date, type, account);
        account.getTransactions().add(transaction);
        transactionRepository.save(transaction);
    }
}
