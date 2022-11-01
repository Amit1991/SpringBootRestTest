package com.learning.bootRestTest.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.bootRestTest.model.UserVO;

public interface UserRepo extends JpaRepository<UserVO, String> {

}
