package com.ados.socialnetwork.service;

import com.ados.socialnetwork.domain.request.LoginRequest;
import com.ados.socialnetwork.domain.request.RegisterRequest;
import com.ados.socialnetwork.domain.response.base.BaseResponse;

public interface AuthService {
    BaseResponse login(LoginRequest request);

    BaseResponse register(RegisterRequest request);
}
