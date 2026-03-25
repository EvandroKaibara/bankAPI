package com.curso.bankapi.controllers.view;

import com.curso.bankapi.models.OperationDTO;
import com.curso.bankapi.services.AccountService;
import com.curso.bankapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/transactions")
public class TransactionViewController {

    //Injetando dependências
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    //Métod0 Responsável por chamar a página de depósito
    @GetMapping("/deposit")
    public String depositForm(Model model) {
        model.addAttribute("accounts", accountService.allAccounts());
        model.addAttribute("operation", new OperationDTO(null, null));
        return "transactions/deposit";
    }

    //Métod0 responsável por salvar o lançamento de um depósito
    @PostMapping("/deposit")
    public String deposit(@ModelAttribute OperationDTO dto) {
        transactionService.deposit(dto.acNumber(), dto.amount());
        return "redirect:/view/accounts";
    }

    //Métod0 Responsável por chamar a página de saque
    @GetMapping("/withdraw")
    public String withdrawForm(Model model) {
        model.addAttribute("accounts", accountService.allAccounts());
        model.addAttribute("operation", new OperationDTO(null, null));
        return "transactions/withdraw";
    }

    //Métod0 responsável por salvar o lançamento de um saque
    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute OperationDTO dto) {
        transactionService.withdraw(dto.acNumber(), dto.amount());
        return "redirect:/view/accounts";
    }
}
