/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.controller;

import com.bm.api.model.Label;
import com.bm.api.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@CrossOrigin("*")
@RequestMapping("/api/labels")
@RestController
public class LabelController {
    
    @Autowired
    private LabelService cs;
    
    @PostMapping(name="/")
    public Label save(@RequestBody Label c) {
        return cs.saveLabel(c);
    }
    
    @PutMapping(name="/")
    public Label update(@RequestBody Label c) {
        return cs.saveLabel(c);
    }
    
    @GetMapping(name="/")
    public Iterable<Label> get() {
        return cs.getCategories();
    }
    
}
