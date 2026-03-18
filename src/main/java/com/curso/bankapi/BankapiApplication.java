package com.curso.bankapi;

import com.curso.bankapi.models.Customer;
import com.curso.bankapi.services.AccountService;
import com.curso.bankapi.services.CustomerService;
import com.curso.bankapi.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class BankapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankapiApplication.class, args);
        testador();
	}

    private static CustomerService customerService;
    private static AccountService accountService;
    private static TransactionService transactionService;

    public BankapiApplication(CustomerService customerService, AccountService accountService, TransactionService transactionService) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    static void testador(){
        //Customer
        //Customer customerA = new Customer("Evandro","000.000.000-00");
        // customerService.createCustomer(customerA);

        //customerService.customerById(1);

        //customerService.allCustomers();

        //Account
        //accountService.createAccount(1);

        //accountService.accountByAcNumber(UUID.fromString("4b3bd440-f6c1-4684-8991-bb94f945071d"));

        //accountService.allAccounts();

        //Transactions
        //transactionService.deposit(UUID.fromString("4b3bd440-f6c1-4684-8991-bb94f945071d"),1000.00f);

        //transactionService.withdraw(UUID.fromString("4b3bd440-f6c1-4684-8991-bb94f945071d"), 250.0f);

        //transactionService.listByAccount(UUID.fromString("4b3bd440-f6c1-4684-8991-bb94f945071d"));
    }
}
