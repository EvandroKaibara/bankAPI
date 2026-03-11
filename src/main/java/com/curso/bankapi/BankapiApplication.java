package com.curso.bankapi;

import com.curso.bankapi.services.AccountService;
import com.curso.bankapi.services.CustomerService;
import com.curso.bankapi.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankapiApplication.class, args);
	}

    private CustomerService customerService;
    private AccountService accountService;
    private TransactionService transactionService;

    public BankapiApplication(CustomerService customerService, AccountService accountService, TransactionService transactionService) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    
}
