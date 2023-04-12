/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.controller;

import com.bm.api.model.MockData;
import com.bm.api.service.MockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@RestController
public class MockDataController {
    
    @Autowired
    private MockDataService mdService;
    
    @GetMapping("/mock-data")
    public Iterable<MockData> getEmployees() {
        return mdService.getMockDataList(50);
    }
    
    @GetMapping("/")
    public String home() {
        return "Hello madafakaa";
    }
    
}
