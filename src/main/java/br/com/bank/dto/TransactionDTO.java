package br.com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record TransactionDTO(
        @NotBlank(message = "Account Id can't be blank")
        int id,
        @Positive(message = "Amount must be greater than zero")
        double amount
) {
}
