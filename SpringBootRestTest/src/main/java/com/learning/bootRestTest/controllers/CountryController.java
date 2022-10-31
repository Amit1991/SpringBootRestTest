package com.learning.bootRestTest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bootRestTest.model.Country;
import com.learning.bootRestTest.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/findAll")
	public List<Country> getAll() {
		
		List<Country> countries = countryService.getAll();
		//countries.stream().forEach(a -> a.setLanguages(null));
		return countries;
	}
	
	
	@DeleteMapping("/deleteOne")
	public boolean deleteOne(@RequestParam long id) {
		
		return countryService.deleteOne(id);
	}
	
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		
		return countryService.deleteAll();
	}
	
	@RequestMapping("/addOne")
	public long addOne(@RequestBody Country country) {
		
		return countryService.saveOne(country);
	}
}
