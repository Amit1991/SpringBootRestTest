package com.learning.bootRestTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bootRestTest.model.Country;
import com.learning.bootRestTest.repoistory.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepo countryRepo;
	
	@Override
	public long saveOne(Country country) {
		
		return countryRepo.save(country).getId();
	}

}
