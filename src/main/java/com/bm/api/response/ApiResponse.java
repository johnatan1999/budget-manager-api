/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.api.response;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author John
 */
public class ApiResponse<T> {
    public static ResponseEntity get(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
            map.put("message", message);
            map.put("status", status.value());
            map.put("data", responseObj);
        return new ResponseEntity(map, status);
    } 
}
