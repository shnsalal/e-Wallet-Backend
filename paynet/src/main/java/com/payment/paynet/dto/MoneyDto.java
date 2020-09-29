package com.payment.paynet.dto;

import java.math.BigDecimal;

public class MoneyDto {
   private BigDecimal balance;

    public MoneyDto() {
    }

    public MoneyDto(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
