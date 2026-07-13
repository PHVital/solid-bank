package br.com.bank.service;

import br.com.bank.domain.CheckingAccount;
import br.com.bank.domain.Transaction;
import br.com.bank.dto.TransactionDTO;
import br.com.bank.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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

    public Page<TransactionDTO> getTransactionsByAccount(Integer accountId, Pageable pageable) {
        Page<Transaction> transactionPage = transactionRepository.findByAccountId(accountId, pageable);
        return transactionPage.map(transaction -> new TransactionDTO(
                transaction.getId(),
                transaction.getAmount()
        ));
    }
}
