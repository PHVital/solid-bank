package br.com.bank.controller;

import br.com.bank.domain.CheckingAccount;
import br.com.bank.dto.TransactionDTO;
import br.com.bank.service.CheckingAccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class CheckingAccountController {
    private CheckingAccountService checkingAccountService;

    public CheckingAccountController(CheckingAccountService checkingAccountService) {
        this.checkingAccountService = checkingAccountService;
    }

    @GetMapping
    public ResponseEntity<CheckingAccount> getAccount(@RequestParam @Positive int id) {
        return ResponseEntity.ok(checkingAccountService.getAccount(id));
    }

    @PostMapping("/deposit")
    public ResponseEntity<CheckingAccount> performDeposit(@RequestBody @Valid TransactionDTO dto) {
        checkingAccountService.performDeposit(dto.id(), dto.amount());
        return ResponseEntity.ok(checkingAccountService.getAccount(dto.id()));
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<CheckingAccount> performWithdrawal(@RequestBody @Valid TransactionDTO dto) {
        checkingAccountService.performWithdrawal(dto.id(), dto.amount());
        return ResponseEntity.ok(checkingAccountService.getAccount(dto.id()));
    }
}
