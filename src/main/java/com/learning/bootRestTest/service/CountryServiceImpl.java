package com.learning.bootRestTest.service;

import java.util.List;

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

	@Override
	public List<Country> getAll() {
		
		return countryRepo.findAll();
	}

	@Override
	public boolean deleteOne(long id) {
		
		try
		{
			countryRepo.deleteById(id);
			return true;
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteAll() {
		
		try
		{
			countryRepo.deleteAll();
			return true;
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}