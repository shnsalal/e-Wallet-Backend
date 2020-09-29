package com.payment.paynet.services;


import com.payment.paynet.dto.TransferDto;
import com.payment.paynet.models.Transaction;

public interface TransactionService {
    // Transaction selfTransactionProccessing(Long id, Transaction userTransaction) throws Exception;
    boolean transferMoney(TransferDto transferDto) throws Exception;
    Transaction transactionIn(Long id, Transaction userTransaction) throws Exception;
    Transaction transactionOut(Long id, Transaction userTransaction) throws Exception;
}
