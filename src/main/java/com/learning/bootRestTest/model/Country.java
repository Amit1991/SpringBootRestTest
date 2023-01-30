package com.learning.bootRestTest.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString(exclude = "languages")
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
	private String continentName;

	@Transient
	@Enumerated(EnumType.STRING)
	private Continent continent;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Language> languages;

	@PrePersist
	void setEnumVal()
	{
		Optional<String> cName = Optional.ofNullable(this.getContinentName());
		this.continentName = cName.orElse(Continent.Unspecified.toString());
	}
	
	@PostLoad
	void resetEnumVal()
	{
		this.continent = Continent.of(this.continentName);
	}
}
