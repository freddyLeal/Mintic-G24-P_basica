package com.mintic.fintech.repositories;

import com.mintic.fintech.models.TransactionType;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer>{
    
    @Query("SELECT tt FROM TransactionType tt WHERE tt.isDebit = true and tt.isUsedByPocket = false")
    List<TransactionType> getTransactionTypeListDebit(Sort sort);
    
    @Query("SELECT tt FROM TransactionType tt WHERE tt.isDebit = false and tt.isUsedByPocket = false")
    List<TransactionType> getTransactionTypeListNotDebit(Sort sort);
    
}
