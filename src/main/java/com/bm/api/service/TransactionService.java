/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.service;

import com.bm.api.model.Category;
import com.bm.api.model.Transaction;
import com.bm.api.repository.CategoryRepository;
import com.bm.api.repository.TransactionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository tr;

    @Autowired
    private CategoryRepository cr;
    
    public Iterable<Transaction> getTransactions() {
        return tr.findAllByOrderByDateDescTimeDesc();
    }
    
    public void deleteTransaction(final String id) {
        tr.deleteById(id);
    }
    
    public Transaction saveTransaction(Transaction t) {
        return tr.save(t);
    }
    
    public Optional<Transaction> getTransaction(final String id) {
        return tr.findById(id);
    }
    
    public Iterable<Transaction> importTransaction(Iterable<Transaction> transactions) {
        for(Transaction t : transactions) {
            String cat = t.getCategory().getName();
            Optional<Category> c = cr.findByName(cat);
            if(c.isEmpty()) {
                Category newCat = new Category();
                newCat.setName(cat);
                newCat = cr.save(newCat);
                t.setCategory(newCat);
            } else {
                t.setCategory(c.get());
            }
        }
        return tr.saveAll(transactions); 
    }
}
