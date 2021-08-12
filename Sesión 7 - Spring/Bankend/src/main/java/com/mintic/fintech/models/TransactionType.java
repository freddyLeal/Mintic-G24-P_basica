package com.mintic.fintech.models;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_type")
public class TransactionType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
        
    @Column(name = "name")
    private String name;
    
    @Column(name = "is_debit")
    private Boolean isDebit;
    
    @Column(name = "is_used_by_pocket")
    private Boolean isUsedByPocket;

    public TransactionType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDebit() {
        return isDebit;
    }

    public void setIsDebit(Boolean isDebit) {
        this.isDebit = isDebit;
    }

    public Boolean getIsUsedByPocket() {
        return isUsedByPocket;
    }

    public void setIsUsedByPocket(Boolean isUsedByPocket) {
        this.isUsedByPocket = isUsedByPocket;
    }
    
    
    
}
