package com.learning.bootRestTest.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.bootRestTest.model.Language;

public interface LanguageRepo extends JpaRepository<Language, Long> {

}
