package br.com.bank;

import br.com.bank.domain.CheckingAccount;
import br.com.bank.repository.CheckingAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CheckingAccountRepository checkingAccountRepository) {
        return args -> {
            if (checkingAccountRepository.count() == 0) {
                checkingAccountRepository.save(new CheckingAccount(999, "Pedro Henrique"));
                System.out.println("Initial account created successfully on PostgreSQL");
            }
        };
    }
}