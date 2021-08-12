package com.mintic.fintech.repositories;

import com.mintic.fintech.models.Wallet;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WalletRepository extends JpaRepository<Wallet, Integer>{
    
//    @Query("SELECT dep FROM Departamento dep WHERE lower(dep.name) like %?1% ")
//    List<Departamento> getDepartamentListByName(String name, Sort sort);
    
}
