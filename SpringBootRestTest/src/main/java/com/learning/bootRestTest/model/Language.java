package com.learning.bootRestTest.model;

import java.util.Optional;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString 
@NoArgsConstructor @AllArgsConstructor()
public class Language extends BaseModel {

	private String languageName;
	private String primaryScriptName;
	private String languageCode;
	private String sampleSentence;

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