package com.userLoginService.userLoginService.repository;

import com.userLoginService.userLoginService.model.CustomUser;

public interface UserRepository {
    void createUser(CustomUser customUser);
    CustomUser findUserByUsername(String username);
}
