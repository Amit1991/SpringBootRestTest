package com.learning.bootRestTest.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.bootRestTest.model.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {

}
