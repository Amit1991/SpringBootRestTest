package com.learning.bootRestTest.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bootRestTest.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {

}
