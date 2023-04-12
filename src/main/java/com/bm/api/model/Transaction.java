/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.model;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author John
 */
@Data
@Entity
@Table(name="Transaction_")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    
    private String description;
    
    private double amount;
    
    @Column(name = "transaction_date")
    private Date date;
    
    @Column(name = "transaction_time")
    private Time time;
    
    @OneToOne
    private Category category;
    
    @Column(name = "state_")
    private int state; 
    
    public Transaction() {}
    
    public Transaction(String id, String description, double amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = new Date(System.currentTimeMillis());
        this.time = new Time(System.currentTimeMillis());
    }
    
}
