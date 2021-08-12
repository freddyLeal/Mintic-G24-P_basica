package com.mintic.fintech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "wallet_transaction")
public class WalletTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    @JsonBackReference
    private Wallet wallet;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_type_id")
    private TransactionType transactionType;

    public WalletTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
    
        
}
