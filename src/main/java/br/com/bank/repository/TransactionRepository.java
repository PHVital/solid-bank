package br.com.bank.repository;


import br.com.bank.domain.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Page<Transaction> findByAccountId(Integer accountId, Pageable pageable);
}
