/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.model;

import lombok.Data;

/**
 *
 * @author John
 */
@Data
public class MockData {
    
    private String value = "Hello World";
    
    public MockData() {}
    public MockData(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
