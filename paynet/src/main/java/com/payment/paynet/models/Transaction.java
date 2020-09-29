package com.payment.paynet.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.payment.paynet.dto.TransactionStatus;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String description;
	private String transactionRef;
	private BigDecimal balance;
	private Date timestamp;
	private TransactionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wallet_id", referencedColumnName = "id")
	@JsonIgnore
    private Wallet wallet;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userAccount_id", referencedColumnName = "id")
    @JsonIgnore
    private UserAccount userAccount;

    public Transaction() {
    }

    public Transaction(Long id, String description, String transactionRef, BigDecimal balance, Date timestamp, TransactionStatus status, Wallet wallet, UserAccount userAccount) {
        this.id = id;
        this.description = description;
        this.transactionRef = transactionRef;
        this.balance = balance;
        this.timestamp = timestamp;
        this.status = status;
        this.wallet = wallet;
        this.userAccount = userAccount;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionRef() {
        return this.transactionRef;
    }

    public void setTransactionRef(String transactionRef) {
        this.transactionRef = transactionRef;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public UserAccount getUserAccount() {
        return this.userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}
