package com.learning.bootRestTest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

@Entity
public class Country extends BaseModel {

	private String countryName;
	private long isdCode;
	private String countryCode;
	private String phoneNumberPattern;
	private String phoneNumberExample;
	private String mobileNumberPattern;
	private String mobileNumberExample;
	private String faxNumberPattern;
	private String faxNumberExample;
	private String pinPattern;
	private String pinExample;
	private String zone;

	@Enumerated(EnumType.STRING)
	private Continent continent;

	@ManyToMany
	private List<Language> languages;

	public long getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(long isdCode) {
		this.isdCode = isdCode;
	}

	public String getPhoneNumberPattern() {
		return phoneNumberPattern;
	}

	public void setPhoneNumberPattern(String phoneNumberPattern) {
		this.phoneNumberPattern = phoneNumberPattern;
	}

	public String getPhoneNumberExample() {
		return phoneNumberExample;
	}

	public void setPhoneNumberExample(String phoneNumberExample) {
		this.phoneNumberExample = phoneNumberExample;
	}

	public String getMobileNumberPattern() {
		return mobileNumberPattern;
	}

	public void setMobileNumberPattern(String mobileNumberPattern) {
		this.mobileNumberPattern = mobileNumberPattern;
	}

	public String getMobileNumberExample() {
		return mobileNumberExample;
	}

	public void setMobileNumberExample(String mobileNumberExample) {
		this.mobileNumberExample = mobileNumberExample;
	}

	public String getFaxNumberPattern() {
		return faxNumberPattern;
	}

	public void setFaxNumberPattern(String faxNumberPattern) {
		this.faxNumberPattern = faxNumberPattern;
	}

	public String getFaxNumberExample() {
		return faxNumberExample;
	}

	public void setFaxNumberExample(String faxNumberExample) {
		this.faxNumberExample = faxNumberExample;
	}

	public String getPinPattern() {
		return pinPattern;
	}

	public void setPinPattern(String pinPattern) {
		this.pinPattern = pinPattern;
	}

	public String getPinExample() {
		return pinExample;
	}

	public void setPinExample(String pinExample) {
		this.pinExample = pinExample;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
