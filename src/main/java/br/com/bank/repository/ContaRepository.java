package br.com.bank.repository;


import br.com.bank.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaCorrente, Integer> {

}
