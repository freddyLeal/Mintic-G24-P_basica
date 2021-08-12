package com.mintic.fintech.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pocket_transaction")
public class PocketTransaction {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @ManyToOne
    @JoinColumn(name="pocket_id", nullable=false)
    private Pocket pocket;

    
    public PocketTransaction() {
    }


    
}
