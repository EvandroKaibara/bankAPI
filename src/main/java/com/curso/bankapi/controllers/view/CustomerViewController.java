package com.curso.bankapi.controllers.view;

import com.curso.bankapi.models.Customer;
import com.curso.bankapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view/customers")
public class CustomerViewController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getCustomersView(Model model){
        model.addAttribute("customers", customerService.allCustomers());
        return "customers/list";
    }

    @GetMapping("/create")
    public String createCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "customers/create";
    }

    @PostMapping("/create")
    public String createCustomerView(@ModelAttribute Customer customer){
        customerService.createCustomer(customer);
        return "redirect:/view/customers";
    }
}
