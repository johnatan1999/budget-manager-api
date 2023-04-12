/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.controller;

import com.bm.api.model.Transaction;
import com.bm.api.response.ApiResponse;
import com.bm.api.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@CrossOrigin("*")
@RequestMapping("/api/transactions")
@RestController
public class TransactionController {
    
    @Autowired
    private TransactionService ts;
    
    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            return ApiResponse.get("Success", HttpStatus.OK, ts.getTransactions());
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Transaction t) {
        try {
            Transaction transaction = ts.saveTransaction(t);
            return ApiResponse.get("Success", HttpStatus.CREATED, transaction);
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @RequestBody Transaction t) {
        try {
            Transaction transaction = ts.saveTransaction(t);
            return ApiResponse.get("Success", HttpStatus.OK, transaction);
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            ts.deleteTransaction(id);
            return ApiResponse.get("Success", HttpStatus.OK, null);
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @RequestMapping(path="/import", method = RequestMethod.POST)
    public ResponseEntity<Object> importTransaction(@RequestBody List<Transaction> t) {
        try {
            return ApiResponse.get("Success", HttpStatus.OK, ts.importTransaction(t));
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
