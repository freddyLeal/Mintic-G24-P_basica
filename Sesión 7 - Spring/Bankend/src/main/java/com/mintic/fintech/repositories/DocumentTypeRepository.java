package com.mintic.fintech.repositories;

import com.mintic.fintech.models.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentTypeRepository extends JpaRepository<DocumentType, String>{
    
}
