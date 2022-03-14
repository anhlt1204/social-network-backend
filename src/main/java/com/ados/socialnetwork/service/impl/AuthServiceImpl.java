package com.ados.socialnetwork.service.impl;

import com.ados.socialnetwork.domain.entity.User;
import com.ados.socialnetwork.domain.request.LoginRequest;
import com.ados.socialnetwork.domain.request.RegisterRequest;
import com.ados.socialnetwork.domain.response.base.BaseResponse;
import com.ados.socialnetwork.domain.response.LoginResponse;
import com.ados.socialnetwork.domain.response.RegisterResponse;
import com.ados.socialnetwork.repository.UserRepo;
import com.ados.socialnetwork.service.AuthService;
import com.ados.socialnetwork.service.BaseService;
import com.ados.socialnetwork.service.CustomUserDetailsService;
import com.ados.socialnetwork.util.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl extends BaseService implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public BaseResponse login(LoginRequest request) {

        LoginResponse response = new LoginResponse();

        try {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
            } catch (DisabledException e) {
                log.error("Ex: {}", e);
                throw new Exception("USER_DISABLED", e);
            } catch (BadCredentialsException e) {
                log.error("Ex: {}", e);
                throw new Exception("INVALID_CREDENTIALS", e);
            }

            UserDetails userdetails = userDetailsService.loadUserByUsername(request.getEmail());
            String token = jwtUtil.generateToken(userdetails);
            User user = userRepo.findByEmail(request.getEmail());
            String email = user.getEmail();

            response.setEmail(email);
            response.setToken(token);
            response.setSuccess();
        } catch (Exception e) {
            log.error("Ex: {}", e);
        }

        return response;
    }

    @Override
    public BaseResponse register(RegisterRequest request) {

        RegisterResponse response = new RegisterResponse();

        try {
            userDetailsService.save(request);
            response.setEmail(request.getEmail());
            response.setSuccess();
        } catch (Exception e) {
            log.error("Ex: {}", e);
        }

        return response;
    }
}
