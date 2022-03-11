package com.ados.socialnetwork.controller;

import com.ados.socialnetwork.domain.request.LoginRequest;
import com.ados.socialnetwork.domain.request.RegisterRequest;
import com.ados.socialnetwork.domain.response.base.BaseResponse;
import com.ados.socialnetwork.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends BaseController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Ok");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test1() {
        return ResponseEntity.ok().body("Ok");
    }

    @PostMapping(value = "/login")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<BaseResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
