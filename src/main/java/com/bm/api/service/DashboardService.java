/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.service;

import com.bm.api.model.IAmountByCategory;
import com.bm.api.repository.CategoryRepository;
import com.bm.api.repository.DashboardRepository;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class DashboardService {
    
    @Autowired
    private DashboardRepository dr;
    
    @Autowired 
    private CategoryRepository cr;
    
    public HashMap<String, Iterable<IAmountByCategory>> getTotalTransactionGroupByCategory() {
        Iterable<IAmountByCategory> income = dr.getTotalIncomeGroupedByCategory();
        Iterable<IAmountByCategory> expense = dr.getTotalExpenseGroupedByCategory();
        HashMap<String, Iterable<IAmountByCategory>> res = new HashMap<>();
        res.put("total_income", income);
        res.put("total_expense", expense);
        return res;
    }
    
}
