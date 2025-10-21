/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jgamb
 */
@RestController
public class LucasController {
    @GetMapping("/math")
    public Map<String, Object> collatz(@RequestParam Integer value){
        
        List<Integer> sec = new ArrayList<>();
        collatzSec(value,sec);
        
        Map<String, Object> resp = new LinkedHashMap<>();
        resp.put("operation ", "collatzsequence");
        resp.put("input",value );
        resp.put("output", sec);

        return resp;
    }
    
    private void collatzSec(Integer n, List<Integer> sec){
        sec.add(n);
        if(n == 1)return;
        else if(n%2==0) collatzSec(n/2,sec);
        else collatzSec(3*n+1,sec);
        
    }
    
    
    
    
    
    
    
}
