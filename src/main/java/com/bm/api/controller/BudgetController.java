/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.controller;

import com.bm.api.model.Budget;
import com.bm.api.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@RestController
@RequestMapping("/api/sources")
public class BudgetController {
    
    @Autowired
    private BudgetService ss;
    
    @GetMapping("/")
    public Iterable<Budget> findAll() {
        return ss.getSources();
    }
    
}
