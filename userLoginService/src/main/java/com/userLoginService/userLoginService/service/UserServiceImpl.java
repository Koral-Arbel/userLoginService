package com.userLoginService.userLoginService.service;

import com.userLoginService.userLoginService.model.CustomUser;
import com.userLoginService.userLoginService.model.CustomUserRequest;
import com.userLoginService.userLoginService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void createUser(CustomUserRequest customUserRequest) throws Exception {
        CustomUser existingCustomUser = userRepository.findUserByUsername(customUserRequest.getUsername());
        if(existingCustomUser != null){
            throw new Exception("Username " + customUserRequest.getUsername() + " is already taken");
        }
        userRepository.createUser(customUserRequest.toCustomUser());

    }

    @Override
    public CustomUser findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
