package com.learning.bootRestTest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.learning.bootRestTest.exception.ResourceNotFoundException;
import com.learning.bootRestTest.model.Language;
import com.learning.bootRestTest.repoistory.LanguageRepo;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepo languageRepo;
	
	@Override
	public List<Language> getAllLanguages() {
		
		return languageRepo.findAll();
	}
	
	@Override
	public Language getOneLanguage(long id) {
		
		return languageRepo.findById(id).get();
	}
	
	@Override
	public Language getOneLanguage(String langName) {
		
		Example<Language> lang = Example.of(new Language(langName, null, null, null));
		return languageRepo.findAll(lang).get(0);
	}

	@Override
	public Language saveOne(Language language) {
		
		language.setCreatedOn(new Date());
		return languageRepo.save(language);
	}

	@Override
	public void deleteAll() {
		
		languageRepo.deleteAll();
	}

	@Override
	public Language updateOne(Long id, Language lang) {
		
		Language existingLang = languageRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Language", "Id", id));
		lang = Language.copyTo(existingLang, lang);
		lang.setUpdatedOn(new Date());
		return languageRepo.save(lang);
	}
}
