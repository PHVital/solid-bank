package br.com.bank.repository;


import br.com.bank.domain.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Integer> {

}
