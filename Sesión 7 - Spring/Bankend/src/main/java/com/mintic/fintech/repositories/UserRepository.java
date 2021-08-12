package com.mintic.fintech.repositories;

import com.mintic.fintech.models.DocumentType;
import com.mintic.fintech.models.User;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Integer>{
    
    
}
