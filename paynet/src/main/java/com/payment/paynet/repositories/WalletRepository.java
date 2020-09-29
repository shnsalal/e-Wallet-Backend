package com.payment.paynet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.paynet.models.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUserAccountId(Long id);
}
