package com.payment.paynet.services;

import java.math.BigDecimal;

import com.payment.paynet.models.Wallet;

public interface WalletService {
    public Wallet addMoney(Long id, BigDecimal balance) throws Exception;
    public BigDecimal viewBalance(Long id);
    public Wallet WithdrawMoney(Long id, BigDecimal balance) throws Exception;
}
