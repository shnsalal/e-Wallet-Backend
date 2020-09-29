package com.payment.paynet.dto;

import java.math.BigDecimal;

public class TransferDto {
    private BigDecimal balance;
    private String sourceUser;
    private String destinationUser;

    public TransferDto() {
    }

    public TransferDto(BigDecimal balance, String sourceUser, String destinationUser) {
        this.balance = balance;
        this.sourceUser = sourceUser;
        this.destinationUser = destinationUser;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSourceUser() {
        return this.sourceUser;
    }

    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }

    public String getDestinationUser() {
        return this.destinationUser;
    }

    public void setDestinationUser(String destinationUser) {
        this.destinationUser = destinationUser;
    }

}
