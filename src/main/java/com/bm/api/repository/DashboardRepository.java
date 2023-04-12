/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.repository;

import com.bm.api.model.IAmountByCategory;
import com.bm.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface DashboardRepository extends JpaRepository<Transaction, String>{
    
    @Query(value="SELECT t.category as category, SUM(t.amount) as totalAmount "
               + "FROM Transaction as t "
               + "WHERE t.amount > 0 GROUP BY t.category.id")
    public Iterable<IAmountByCategory> getTotalIncomeGroupedByCategory();
    
    @Query(value="SELECT t.category as category, SUM(t.amount) as totalAmount "
               + "FROM Transaction as t "
               + "WHERE t.amount < 0 GROUP BY t.category.id")
    public Iterable<IAmountByCategory> getTotalExpenseGroupedByCategory();
    
}
