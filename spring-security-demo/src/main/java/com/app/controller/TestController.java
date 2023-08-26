package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	public TestController() {
		System.out.println("in ctor of "+getClass());
	}
	
	@GetMapping("/customer")
	public String test1() {
		return "Hello CUstomer";
	}
	
	@GetMapping("/admin")
	public String test2() {
		return "Hello admin";
	}
	
	@GetMapping("/home")
	public String test3() {
		return "Hello All welcome to home page";
	}
}
