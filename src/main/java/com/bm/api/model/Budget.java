/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author John
 */
@Data
@Entity
@Table(name="Budget")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Budget {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;
    
    private String description;
    
    @Column(name = "state_")
    private String state;
    
//    @OneToMany(mappedBy = "source", fetch = FetchType.LAZY)
//    private List<Transaction> transactions;
    
    public Budget() {
//        transactions = new ArrayList<>();
    }

    public Budget(String id, String description) {
        this();
        this.id = id;
        this.description = description;
    }
   
}
