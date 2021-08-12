package com.mintic.fintech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pocket")
public class Pocket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @OneToMany(mappedBy="pocket")
    private List<PocketTransaction> pocketTransactionList;

    public Pocket() {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<PocketTransaction> getPocketTransactionList() {
        return pocketTransactionList;
    }

    public void setPocketTransactionList(List<PocketTransaction> pocketTransactionList) {
        this.pocketTransactionList = pocketTransactionList;
    }

    
}
