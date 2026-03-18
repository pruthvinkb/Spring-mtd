package com.example.Backand.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AddController {

    @GetMapping("/add")
    public Map<String, Object> add(@RequestParam(defaultValue = "0") int a, @RequestParam(defaultValue = "0") int b) {
        int result = a + b;
        Map<String, Object> response = new HashMap<>();
        response.put("num1", a);
        response.put("num2", b);
        response.put("result", result);
        return response;
    }
}