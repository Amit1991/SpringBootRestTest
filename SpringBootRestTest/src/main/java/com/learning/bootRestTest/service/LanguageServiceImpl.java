package com.learning.bootRestTest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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
	public long saveOne(Language language) {
		
		return languageRepo.save(language).getId();
	}

	@Override
	public void deleteAll() {
		
		languageRepo.deleteAll();
	}

	@Override
	public long updateOne(Long id, String langName, Language lang) {
		
		Language existingLang = null;
		
		if(id == null)
		{
			id = getOneLanguage(langName).getId();
		}
		else
		{
			existingLang = getOneLanguage(id);
			lang = Language.copyTo(existingLang, lang);
		}
		
		lang.setId(id);
		lang.setUpdatedOn(new Date());
		
		return saveOne(lang);
	}
}
