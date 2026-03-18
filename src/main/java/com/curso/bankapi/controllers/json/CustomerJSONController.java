package com.curso.bankapi.controllers.json;

import com.curso.bankapi.models.Customer;
import com.curso.bankapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/json/customers")
public class CustomerJSONController {
    @Autowired
    private CustomerService customerService;

    //Endpoint: http://localhost:8080/json/customers
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.allCustomers();
    }

    //Endpoint: http://localhost:8080/json/customers/customerId
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId){
        return customerService.customerById(customerId);
    }


    //Endpoint: http://localhost:8080/json/customer/create
    //Body: {"name": "Evandro", "cpf": "000.000.000-00"}
}
