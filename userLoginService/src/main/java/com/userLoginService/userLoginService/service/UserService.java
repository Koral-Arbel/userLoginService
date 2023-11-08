package com.userLoginService.userLoginService.service;

import com.userLoginService.userLoginService.model.CustomUser;
import com.userLoginService.userLoginService.model.CustomUserRequest;

public interface UserService {
    void createUser(CustomUserRequest customUser) throws Exception;
    CustomUser findUserByUsername(String username);
}
