package br.com.gabrizord.springrestdemo.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtService jwtService;

    public AuthService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String login(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

}
