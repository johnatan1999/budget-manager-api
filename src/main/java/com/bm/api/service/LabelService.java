/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.service;

import com.bm.api.model.Label;
import com.bm.api.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class LabelService {
    
    @Autowired
    private LabelRepository cr;
    
    public Iterable<Label> getCategories() {
        return cr.findAll();
    }
    
    public Label saveLabel(Label c) {
        return cr.save(c);
    }
    
    public Iterable<Label> importLabel(Iterable<Label> c) {
        return cr.saveAll(c);
    }
    
    public void deleteLabel(String id) {
        cr.deleteById(id);
    }
}
