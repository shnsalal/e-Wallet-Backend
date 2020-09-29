package com.payment.paynet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.paynet.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
