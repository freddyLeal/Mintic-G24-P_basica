package com.mintic.fintech.repositories;

import com.mintic.fintech.models.Pocket;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PocketRepository extends JpaRepository<Pocket, Integer>{
    
    
}
