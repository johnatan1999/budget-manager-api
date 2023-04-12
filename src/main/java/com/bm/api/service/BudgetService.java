/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.service;

import com.bm.api.model.Budget;
import com.bm.api.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class BudgetService {
    
    @Autowired
    private BudgetRepository sr;
    
    public Iterable<Budget> getSources() {
        return sr.findAll();
    }
    
}
