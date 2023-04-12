/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.service;

import com.bm.api.model.Category;
import com.bm.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository cr;
    
    public Iterable<Category> getCategories() {
        return cr.findAll();
    }
    
    public Category saveCategory(Category c) {
        return cr.save(c);
    }
    
    public Iterable<Category> importCategory(Iterable<Category> c) {
        return cr.saveAll(c);
    }
    
    public void deleteCategory(String id) {
        cr.deleteById(id);
    }
}
