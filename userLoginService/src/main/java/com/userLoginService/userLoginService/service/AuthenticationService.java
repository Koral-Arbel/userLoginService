package com.userLoginService.userLoginService.service;

import com.userLoginService.userLoginService.security.model.AuthenticationRequest;
import com.userLoginService.userLoginService.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;

}
