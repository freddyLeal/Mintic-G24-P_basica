package com.mintic.fintech.controllers;

import com.mintic.fintech.models.DocumentType;
import com.mintic.fintech.models.TransactionType;
import com.mintic.fintech.models.User;
import com.mintic.fintech.repositories.DocumentTypeRepository;
import com.mintic.fintech.repositories.TransactionTypeRepository;
import com.mintic.fintech.repositories.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ConfigController {
    
    @Autowired
    DocumentTypeRepository documentTypeRepository;
    
    @Autowired
    TransactionTypeRepository transactionTypeRepository;
    
    @Autowired
    UserRepository UserRepository;

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> test(){
        Map<String, Object> data = new HashMap();
        data.put("nombre", "Freddy");
        data.put("apellido", "Leal");
        data.put("edad", 35);
        return new ResponseEntity(data, HttpStatus.OK );
    }
        
    
    @GetMapping("/get_document_type_list")
    public ResponseEntity<List<DocumentType>> getDocumentTypeList(){
        List<DocumentType> dtList = documentTypeRepository.findAll();
        return new ResponseEntity(dtList, HttpStatus.OK );
    }
    
    
    @GetMapping("/get_document_type_by_code/{code}")
    public ResponseEntity<DocumentType> getDocumentTypeByCode(@PathVariable("code") String code ){
        Optional<DocumentType> dt = documentTypeRepository.findById(code);
        if( dt.isPresent() ){
            return new ResponseEntity(dt.get(), HttpStatus.OK );
        } else {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
    }
    
    
    @GetMapping("/get_user_by_id/{id}")
    public ResponseEntity<DocumentType> getUserById(@PathVariable("id") Integer id ){
        Optional<User> user = UserRepository.findById(id);
        if( user.isPresent() ){
            return new ResponseEntity(user.get(), HttpStatus.OK );
        } else {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
    }
    
    
    
    @GetMapping("/get_transaction_type_debit")
    public ResponseEntity<List<TransactionType>> getTransactionTypeDebit(){
        List<TransactionType> transactionTypeList = transactionTypeRepository.getTransactionTypeListDebit(Sort.by("name"));
        return new ResponseEntity(transactionTypeList, HttpStatus.OK );
    }
    
    @GetMapping("/get_transaction_type_not_debit")
    public ResponseEntity<List<TransactionType>> getTransactionTypeNotDebit(){
        List<TransactionType> transactionTypeList = transactionTypeRepository.getTransactionTypeListNotDebit(Sort.by("name"));
        return new ResponseEntity(transactionTypeList, HttpStatus.OK );
    }
  
  
}
