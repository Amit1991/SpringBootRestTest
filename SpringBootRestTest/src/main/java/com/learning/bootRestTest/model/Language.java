package com.learning.bootRestTest.model;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;

@Entity
public class Language extends BaseModel {

	private String languageName;
	private String primaryScriptName;
	private String languageCode;
	private String sampleSentence;

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getPrimaryScriptName() {
		return primaryScriptName;
	}

	public void setPrimaryScriptName(String primaryScriptName) {
		this.primaryScriptName = primaryScriptName;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getSampleSentence() {
		return sampleSentence;
	}

	public void setSampleSentence(String sampleSentence) {
		this.sampleSentence = sampleSentence;
	}

	public Language() {
		
	}
	
	public Language(String languageName, String primaryScriptName, String languageCode, String sampleSentence) 
	{
		this.languageName = languageName;
		this.primaryScriptName = primaryScriptName;
		this.languageCode = languageCode;
		this.sampleSentence = sampleSentence;
		this.setCreatedOn(new Date());
	}

	public static Language copyTo(Language existingLang, Language lang) {
		
		Optional<String> langName = Optional.ofNullable(lang.getLanguageName());
		existingLang.setLanguageName(langName.orElse(existingLang.getLanguageName()));
		
		Optional<String> langCode = Optional.ofNullable(lang.getLanguageCode());
		existingLang.setLanguageCode(langCode.orElse(existingLang.getLanguageCode()));
		
		Optional<String> scriptName = Optional.ofNullable(lang.getPrimaryScriptName());
		existingLang.setPrimaryScriptName(scriptName.orElse(existingLang.getPrimaryScriptName()));
		
		Optional<String> egSentence = Optional.ofNullable(lang.getSampleSentence());
		existingLang.setSampleSentence(egSentence.orElse(existingLang.getSampleSentence()));
		
		return existingLang;
	}
}