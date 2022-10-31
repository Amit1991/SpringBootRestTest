package com.learning.bootRestTest.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bootRestTest.model.Language;
import com.learning.bootRestTest.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/getAll")
	public List<Language> getAllLanguages() {
		
		return languageService.getAllLanguages();
	}
	
	@PostMapping("/addOne")
	public long addOne(@RequestBody Language lang)
	{
		if(lang.getId() > 0)
		{
			return languageService.updateOne(lang.getId(), null, lang);
		}
		else 
		{
			lang.setCreatedOn(new Date());
			return languageService.saveOne(lang);
		}
	}
	
	@GetMapping("populate")
	public List<Long> populateData() {
		
		List<Long> data = new ArrayList<>();
		List<Language> existingData = getAllLanguages();
		
		if(existingData != null && existingData.size() > 0)
		{
			languageService.deleteAll();
		}
		
		data.add(languageService.saveOne(new Language("Hindi", "Devnagri", "hi", "यह एक उदाहरण वाक्य है.")));
		data.add(languageService.saveOne(new Language("English", "Roman", "en", "This is a sample sentence.")));
		
		return data;
	}
}
