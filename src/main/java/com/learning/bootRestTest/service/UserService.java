package com.learning.bootRestTest.service;

import com.learning.bootRestTest.model.UserVO;

public interface UserService {

    UserVO getUserByUsername(String username);
}
