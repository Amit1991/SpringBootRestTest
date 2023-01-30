package com.learning.bootRestTest.service;

import com.learning.bootRestTest.model.Role;
import com.learning.bootRestTest.model.UserVO;
import com.learning.bootRestTest.repoistory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserVO getUserByUsername(String username) {

        return userRepo.findByUsername(username).orElse(UserVO.unauthorisedUser());
    }
}
