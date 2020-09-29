package com.payment.paynet.servicesImpl;

import java.util.Date;

import com.payment.paynet.dto.TransactionStatus;
import com.payment.paynet.dto.TransferDto;
import com.payment.paynet.dto.ViewTransactionDto;
import com.payment.paynet.models.Transaction;
import com.payment.paynet.models.UserAccount;
import com.payment.paynet.models.Wallet;
import com.payment.paynet.repositories.TransactionRepository;
import com.payment.paynet.services.TransactionService;
import com.payment.paynet.services.UserAccountService;
import com.payment.paynet.services.WalletService;
import com.payment.paynet.util.TransactionReferenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    WalletService walletService;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    UserAccountService userAccountService;

    // @Override
    // public Transaction selfTransactionProccessing(Long id, Transaction
    // userTransaction) throws Exception {
    // Wallet wallet = walletService.addMoney(id, userTransaction.getBalance());
    // Transaction transaction = new Transaction();
    // transaction.setBalance(userTransaction.getBalance());
    // transaction.setDescription("Credit");
    // transaction.setStatus(TransactionStatus.SUCCESS);
    // transaction.setWallet(wallet);
    // transaction.setUserAccount(wallet.getUserAccount());
    // transaction.setTimestamp(new Date());
    // return transactionRepository.save(transaction);
    // }

    @Override
    public boolean transferMoney(TransferDto transferDto) throws Exception {
        UserAccount user1 = userAccountService.findByMobileNo(transferDto.getSourceUser());
        UserAccount user2 = userAccountService.findByMobileNo(transferDto.getDestinationUser());
        if (user1 == null) {
            throw new Exception("User Not Found");
        }
        if (user2 == null) {
            throw new Exception("User Not Found");
        }
        Transaction transaction = new Transaction();
        transaction.setBalance(transferDto.getBalance());

        transactionOut(user1.getId(), transaction);
        transactionIn(user2.getId(), transaction);
        return true;
    }

    @Override
    public Transaction transactionIn(Long id, Transaction userTransaction) throws Exception {
        Wallet wallet = walletService.addMoney(id, userTransaction.getBalance());
        Transaction transaction = new Transaction();
        transaction.setBalance(userTransaction.getBalance());
        transaction.setDescription("Credited");
        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setWallet(wallet);
        transaction.setTransactionRef(TransactionReferenceGenerator.generateReference(id));
        transaction.setUserAccount(wallet.getUserAccount());
        transaction.setTimestamp(new Date());
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction transactionOut(Long id, Transaction userTransaction) throws Exception {
        Wallet wallet = walletService.WithdrawMoney(id, userTransaction.getBalance());
        Transaction transaction = new Transaction();
        transaction.setBalance(userTransaction.getBalance());
        transaction.setDescription("Debited");
        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setWallet(wallet);
        transaction.setTransactionRef(TransactionReferenceGenerator.generateReference(id));
        transaction.setUserAccount(wallet.getUserAccount());
        transaction.setTimestamp(new Date());
        return transactionRepository.save(transaction);
    }

    @Override
    public ViewTransactionDto viewTransaction(Long id) throws Exception {
        return  userAccountService.transactionList(id);
    }

}
