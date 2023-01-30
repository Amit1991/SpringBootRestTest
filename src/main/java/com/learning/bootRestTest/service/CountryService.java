package com.learning.bootRestTest.service;

import java.util.List;

import com.learning.bootRestTest.model.Country;

public interface CountryService {

	public List<Country> getAll();
	public long saveOne(Country country);
	public boolean deleteOne(long id);
	public boolean deleteAll();
}
