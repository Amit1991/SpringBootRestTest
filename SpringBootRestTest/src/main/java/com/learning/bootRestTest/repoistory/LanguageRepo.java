package com.learning.bootRestTest.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bootRestTest.model.Language;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Long> {

}
