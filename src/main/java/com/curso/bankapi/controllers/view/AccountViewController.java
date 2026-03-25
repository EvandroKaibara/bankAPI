package com.curso.bankapi.controllers.view;

import com.curso.bankapi.services.AccountService;
import com.curso.bankapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/view/accounts")
public class AccountViewController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getAllAccountsForm(Model model){
        model.addAttribute("accounts",accountService.allAccounts());
        return "accounts/list";
    }

    @GetMapping("/create")
    public String createAccountForm(Model model){
        model.addAttribute("customers",customerService.allCustomers());
        return "accounts/create";
    }

    @PostMapping("/create")
    public String createAccountView(@RequestParam Integer customerId){
        accountService.createAccount(customerId);
        return "redirect:/view/accounts";
    }
}
