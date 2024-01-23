package edu.miu.waa.lab2.service;


import edu.miu.waa.lab2.dto.request.LoginRequest;
import edu.miu.waa.lab2.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab2.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
