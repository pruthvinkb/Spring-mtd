package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/add")
    public int addNumbers(@RequestParam int a, @RequestParam int b){
        AdditionOfNumbers obj = new AdditionOfNumbers();
        return obj.add(a, b);
        //http://localhost:8080/add?a=10&b=20
    }

    @PostMapping("/studentResults")
    public StudentResults studentResults(@RequestBody StudentResults student){
        student.calculateTotal();
        return student;
    }
}