package com.curso.bankapi.controllers.json;

import com.curso.bankapi.models.OperationDTO;
import com.curso.bankapi.models.Transaction;
import com.curso.bankapi.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/json/transactions")
public class TransactionJSONController {
    @Autowired
    private TransactionService transactionService;

    //Endpoint: http://localhost:8080/json/transactions/acNumber
    @GetMapping("/{acNumber}")
    public List<Transaction> getAllTransactionsByAcNumber(@PathVariable UUID acNumber){
        return transactionService.listByAccount(acNumber);
    }

    //Endpoint: http://localhost:8080/json/transactions/deposit
    //Body: {"acNumber" : "{acNumber}", "amount" : 0;
    @PostMapping("/deposit")
    public ResponseEntity<Transaction> postDeposit(@RequestBody OperationDTO dto){
        Transaction transaction = transactionService.deposit(dto.acNumber(), dto.amount());
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }

    //Endpoint: http://localhost:8080/json/transactions/withdraw
    //Body: {"acNumber" : "{acNumber}", "amount" : 0;
    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> postWithdraw(@RequestBody OperationDTO dto){
        Transaction transaction = transactionService.withdraw(dto.acNumber(), dto.amount());
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }
}
