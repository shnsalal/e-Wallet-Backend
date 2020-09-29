package com.payment.paynet.controllers;

import com.payment.paynet.dto.TransferDto;
import com.payment.paynet.models.Transaction;
import com.payment.paynet.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class Transactioncontroller {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/add-money/{id}")
    public ResponseEntity<?> addMoney(@PathVariable Long id, @RequestBody Transaction userTransaction) {
        try {
            Transaction transaction = transactionService.transactionIn(id, userTransaction);
            return ResponseEntity.accepted().body(transaction);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
     }
 
    @PostMapping("/tranfer-money")
    public ResponseEntity<?> tranferMoney(@RequestBody TransferDto transferDto) {
        try {
           if(transactionService.transferMoney(transferDto)) {
            return ResponseEntity.accepted().body("Transaction Successful!");
           }
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.accepted().body("Transaction Unsuccessful!");
     }
}
