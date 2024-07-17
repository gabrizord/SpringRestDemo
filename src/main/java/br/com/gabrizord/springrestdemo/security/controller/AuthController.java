package br.com.gabrizord.springrestdemo.security.controller;

import br.com.gabrizord.springrestdemo.security.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService AuthService;

    public AuthController(AuthService AuthService) {
        this.AuthService = AuthService;
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return AuthService.login(authentication);
    }
}
