/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.controller;

import com.bm.api.model.IAmountByCategory;
import com.bm.api.response.ApiResponse;
import com.bm.api.service.DashboardService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@CrossOrigin("*")
@RequestMapping("/api/dashboard")
@RestController
public class DashboardController {
    
    @Autowired
    private DashboardService ds;
    
    @GetMapping("/total-transaction/grouped-by-category")
    public ResponseEntity getTotalIncomeGroupedByCategory() {
        try {
            return ApiResponse.get("Success", HttpStatus.OK, ds.getTotalTransactionGroupByCategory());
        } catch(Exception ex) {
            System.err.println("com.bm.api.controller.DashboardController.getTotalIncomeGroupedByCategory() " + ex.getMessage());
            return ApiResponse.get(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    
}
