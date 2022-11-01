package com.learning.bootRestTest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bootRestTest.model.Language;
import com.learning.bootRestTest.service.LanguageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/language")
@Slf4j
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/getAll")
	public List<Language> getAllLanguages() {
		
		log.info("Finding all languages...");
		return languageService.getAllLanguages();
	}
	
	@PostMapping("/addOne")
	public ResponseEntity<Language> addOne(@RequestBody Language lang)
	{
		log.info("Adding one language");
		
		return new ResponseEntity<Language>(languageService.saveOne(lang), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateOne/{id}")
	public ResponseEntity<?> updateOne(@PathVariable("id") long id, @RequestBody Language lang)
	{
		log.info("Updating one language");
		try
		{
			lang = languageService.updateOne(id, lang);
			return new ResponseEntity<Language>(lang, HttpStatus.OK);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/populate")
	public HttpStatus populateData() {
		
		List<Language> existingData = getAllLanguages();
		
		if(existingData != null && existingData.size() > 0)
		{
			languageService.deleteAll();
			existingData.clear();
		}
		
		existingData.add(languageService.saveOne(new Language("Hindi", "Devnagri", "hi", "यह एक उदाहरण वाक्य है.")));
		existingData.add(languageService.saveOne(new Language("English", "Roman", "en", "This is a sample sentence.")));
		
		return HttpStatus.IM_USED;
	}
}
