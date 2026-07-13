package br.com.bank;

import br.com.bank.domain.CheckingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    private CheckingAccount checkingAccount;

    @BeforeEach
    void setUp() {
        checkingAccount = new CheckingAccount(1, "Pedro Henrique");
    }

    @Test
    void shouldThrowExceptionWhenWithdrawalAmountIsGreaterThanBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> checkingAccount.withdrawal(50));
    }

    @Test
    void shouldIncreaseBalanceWhenDepositIsValid() {
        double oldBalance = checkingAccount.getBalance();
        checkingAccount.deposit(100);
        Assertions.assertEquals(100.00, checkingAccount.getBalance());
    }

    @Test
    void shouldThrowExceptionWhenDepositIsZeroOrNegative() {
        Assertions.assertAll("Grouped Assertions of Deposit",
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> checkingAccount.deposit(0)),
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> checkingAccount.deposit(-10))
        );
    }

    @Test
    void shouldDecreaseBalanceWhenWithdrawalIsValid() {
        checkingAccount.deposit(100);
        checkingAccount.withdrawal(20);
        Assertions.assertEquals(80.00, checkingAccount.getBalance());
    }
}
