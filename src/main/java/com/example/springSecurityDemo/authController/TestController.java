package com.example.springSecurityDemo.authController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestController {
	
	@GetMapping("/Hello")
	public String Greetings() {
		return "Hi";
	}
}
