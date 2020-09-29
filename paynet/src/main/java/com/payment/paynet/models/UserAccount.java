package com.payment.paynet.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	private String password;
    private String mobileNo;
    
    @OneToOne(mappedBy = "userAccount")
	private Wallet wallet;

    @OneToMany(mappedBy = "userAccount")
    private List<Transaction> transaction;

    public UserAccount() {
    }

    public UserAccount(Long id, String fullName, String password, String mobileNo, Wallet wallet, List<Transaction> transaction) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.mobileNo = mobileNo;
        this.wallet = wallet;
        this.transaction = transaction;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Wallet getWallet() {
        return this.wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public List<Transaction> getTransaction() {
        return this.transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }
}
