/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.repository;

import com.bm.api.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {
    public Iterable<Transaction> findAllByOrderByDateDescTimeDesc();
}
