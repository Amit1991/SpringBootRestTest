package com.learning.bootRestTest.repoistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.bootRestTest.model.UserVO;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserVO, String> {

    Optional<UserVO> findByUsername(String username);
}
