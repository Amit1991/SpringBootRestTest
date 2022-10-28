package com.learning.bootRestTest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {
	

	@GetMapping("/comeGetMe")
	public String getMessage() {
		
		return "Hi everyone..  this is my first API call.";
	}
}
