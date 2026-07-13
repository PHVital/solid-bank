package br.com.bank.controller;

import br.com.bank.dto.TransactionDTO;
import br.com.bank.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<Page<TransactionDTO>> getTransactions(@PathVariable Integer accountId, Pageable pageable) {
        return ResponseEntity.ok(transactionService.getTransactionsByAccount(accountId, pageable));
    }
}
