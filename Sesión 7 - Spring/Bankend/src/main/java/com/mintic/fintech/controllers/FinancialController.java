package com.mintic.fintech.controllers;

import com.mintic.fintech.models.DocumentType;
import com.mintic.fintech.models.TransactionType;
import com.mintic.fintech.models.User;
import com.mintic.fintech.models.Wallet;
import com.mintic.fintech.models.WalletTransaction;
import com.mintic.fintech.repositories.TransactionTypeRepository;
import com.mintic.fintech.repositories.UserRepository;
import com.mintic.fintech.repositories.WalletRepository;
import com.mintic.fintech.repositories.WalletTransactionRepository;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class FinancialController {
    
    @Autowired
    WalletRepository walletRepository;
    
    @Autowired
    WalletTransactionRepository walletTransactionRepository;
    
    @Autowired
    TransactionTypeRepository transactionTypeRepository;
    
    @GetMapping("/get_wallet_log_by_wallet/{id}")
    public ResponseEntity<List<WalletTransaction>> getWalletLogByWalletId(@PathVariable("id") Integer walletId ){
        List<WalletTransaction> walletLog = walletTransactionRepository.getWalletLogByWalletId(walletId, Sort.by("id").descending() );
        return new ResponseEntity(walletLog, HttpStatus.OK );
    }
    
    @PostMapping("/set_reload_wallet")
    public ResponseEntity<Map<String, Object>> setReloadWallet(@RequestBody Map<String,Object> body){
        Map<String, Object> response = new HashMap();
        
        Integer walletId = (Integer) body.get("id"); 
        Integer amount = (Integer) body.get("amount");
        Integer ttId = (Integer) body.get("id");
        BigDecimal amount_to_add = new BigDecimal(amount);
        
        TransactionType tt = transactionTypeRepository.getById( ttId );
        Wallet wallet = walletRepository.getById( walletId );
        
        WalletTransaction wt = new WalletTransaction();
        wt.setAmount( amount_to_add );
        wt.setTransactionType( tt );
        wt.setWallet(wallet);
        walletTransactionRepository.save(wt);
        
        wallet.setAmount( wallet.getAmount().add(amount_to_add)  );
        walletRepository.save( wallet );
        
        return new ResponseEntity(response, HttpStatus.OK );
    }
    
    
    
}
