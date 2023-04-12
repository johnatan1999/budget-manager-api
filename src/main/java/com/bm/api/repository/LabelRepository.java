/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.repository;

import com.bm.api.model.Label;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author John
 */
public interface LabelRepository extends CrudRepository<Label, String> {
    
}
