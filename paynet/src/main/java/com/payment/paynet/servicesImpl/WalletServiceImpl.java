package com.payment.paynet.servicesImpl;

import java.math.BigDecimal;

import com.payment.paynet.models.Wallet;
import com.payment.paynet.repositories.WalletRepository;
import com.payment.paynet.services.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet addMoney(Long id, BigDecimal balance) throws Exception {
        Wallet wallet = walletRepository.findByUserAccountId(id);
        if(wallet == null) {
            throw new Exception("User Not Found");
        }
        if(balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Low Balance");
        }
        wallet.setBalance(balance.add(wallet.getBalance()));
        Wallet  returnWallet = walletRepository.save(wallet);
        return returnWallet;
    }

    @Override
    public BigDecimal viewBalance(Long id) {
        Wallet wallet = walletRepository.findByUserAccountId(id);
        return wallet.getBalance();
    }

    @Override
    public Wallet WithdrawMoney(Long id, BigDecimal balance) throws Exception {
        Wallet wallet = walletRepository.findByUserAccountId(id);
        if(wallet == null) {
            throw new Exception("User Not Found");
        }
        if(balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Insufficent Amount");
        }
        if(balance.compareTo(wallet.getBalance()) == 1) {
            throw new Exception("Low Balance in Acoount");
        }
        wallet.setBalance(wallet.getBalance().subtract(balance));
        Wallet  returnWallet = walletRepository.save(wallet);
        return returnWallet;
    }
    
}
