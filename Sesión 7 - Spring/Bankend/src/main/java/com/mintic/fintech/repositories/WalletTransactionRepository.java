package com.mintic.fintech.repositories;

import com.mintic.fintech.models.WalletTransaction;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Integer>{
    
    @Query("SELECT tt FROM WalletTransaction tt WHERE tt.wallet.id = ?1 ")
    List<WalletTransaction> getWalletLogByWalletId(Integer walletId, Sort sort);
    
}
