package com.learning.bootRestTest.service;

import java.util.List;

import com.learning.bootRestTest.model.Language;

public interface LanguageService {

	public List<Language> getAllLanguages();
	public long saveOne(Language language);
	public long updateOne(Long id, String langName, Language lang);
	public void deleteAll();
	public Language getOneLanguage(long id);
	public Language getOneLanguage(String langName);
}
