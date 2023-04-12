/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.controller;

import com.bm.api.model.Category;
import com.bm.api.response.ApiResponse;
import com.bm.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@CrossOrigin("*")
@RequestMapping("/api/categories")
@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService cs;
    
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Category c) {
        try {
            Category category = cs.saveCategory(c);
            return ApiResponse.get("Success", HttpStatus.CREATED, category);
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Category c) {
        try {
            Category category = cs.saveCategory(c);
            return ApiResponse.get("Success", HttpStatus.OK, category);
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> get() {
        try {
            return ApiResponse.get("Success", HttpStatus.OK, cs.getCategories());
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) {
        try {
            cs.deleteCategory(id);
            return ApiResponse.get("Success", HttpStatus.OK, null);
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
    @RequestMapping(path="/import", method = RequestMethod.POST)
    public ResponseEntity<Object> importCategories(@RequestBody Iterable<Category> c) {
        try {
            return ApiResponse.get("Success", HttpStatus.OK, cs.importCategory(c));
        } catch(Exception ex) {
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
