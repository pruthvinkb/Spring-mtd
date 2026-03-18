package com.example.Backend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Addition Backend is running!";
	}

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
