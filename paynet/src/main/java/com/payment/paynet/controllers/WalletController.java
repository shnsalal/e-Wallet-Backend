package com.payment.paynet.controllers;

import com.payment.paynet.dto.MoneyDto;
import com.payment.paynet.models.Wallet;
import com.payment.paynet.services.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/add-money/{id}")
    public ResponseEntity<?> addMoney(@PathVariable Long id, @RequestBody MoneyDto moneyDto) {
       try {
           Wallet wallet = walletService.addMoney(id, moneyDto.getBalance());
           return ResponseEntity.accepted().body(wallet);
       } catch (Exception ex) {
           return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/view-balance/{id}")
    public ResponseEntity<?> viewBalance(@PathVariable Long id) {
        try {
            return ResponseEntity.accepted().body(walletService.viewBalance(id));
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/withdraw-money/{id}")
    public ResponseEntity<?> withdrawMoney(@PathVariable Long id, @RequestBody MoneyDto moneyDto) {
       try {
           Wallet wallet = walletService.WithdrawMoney(id, moneyDto.getBalance());
           return ResponseEntity.accepted().body(wallet);
       } catch (Exception ex) {
           return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }
}
