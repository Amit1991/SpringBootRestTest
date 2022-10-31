package com.learning.bootRestTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bootRestTest.model.Country;
import com.learning.bootRestTest.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/addOne")
	public long addOne(@RequestBody Country country) {
		
		return countryService.saveOne(country);
	}
}
