package com.hotelmanagement.web.controller;

import com.hotelmanagement.dto.LoginRequest;
import com.hotelmanagement.domain.entity.User;
import com.hotelmanagement.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService auth;

    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(auth.login(req.username, req.password));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        auth.logout();
        return ResponseEntity.ok().build();
    }
}
