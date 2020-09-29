package com.payment.paynet.dto;
import com.payment.paynet.models.Transaction;
import java.util.List;

public class ViewTransactionDto {
    private String fullName;
    private List<Transaction> transaction;

    public ViewTransactionDto() {
    }

    public ViewTransactionDto(String fullName, List<Transaction> transaction) {
        this.fullName = fullName;
        this.transaction = transaction;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Transaction> getTransaction() {
        return this.transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
