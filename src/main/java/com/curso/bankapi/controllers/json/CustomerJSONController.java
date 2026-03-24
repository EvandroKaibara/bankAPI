package com.curso.bankapi.controllers.json;

import com.curso.bankapi.models.Customer;
import com.curso.bankapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    //Endpoint: http://localhost:8080/json/customers/create
    //Body: {"name": "Evandro", "cpf": "000.000.000-00"}
    @PostMapping("/create")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

}
