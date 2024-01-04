package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testcontroller {

	@GetMapping("/getname")
	public String getname() {
		System.out.println("get name from 8098");
		
		return "hello server from 8098 ";
		
	}
}
