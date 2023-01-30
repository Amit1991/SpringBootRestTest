package com.learning.bootRestTest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Publisher extends BaseModel {

	private String name;
	private String registeredCompanyName;
	private String registrationNumber;
	private String address;
	private String phoneNumber;
	private String emailId;
	private String website;
	private Date establishedOn;
	
	@ManyToMany
	private List<Language> languages;
}
