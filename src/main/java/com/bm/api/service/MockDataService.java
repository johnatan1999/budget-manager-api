/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.service;

import com.bm.api.model.MockData;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author John
 */
@Service
public class MockDataService {
    
    public MockData getMockData() {
        return new MockData();
    }
    
    public Iterable<MockData> getMockDataList(int nb) {
        List<MockData> data = new ArrayList<>();
        for(int i=0; i<nb; i++) {
            data.add(new MockData("Income n°"+(i+1)));
        }
        return data;
    }
    
}
