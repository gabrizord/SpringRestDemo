package br.com.gabrizord.springrestdemo.security.controller;

import br.com.gabrizord.springrestdemo.security.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private final AuthService AuthService;

    public AuthController(AuthService AuthService) {
        this.AuthService = AuthService;
    }

    @GetMapping("/authorities")
    public Map<String,Object> getPrincipalInfo(JwtAuthenticationToken principal) {
        Map<String,Object> info = new HashMap<>();
        info.put("name", principal.getName());
        info.put("authorities", principal.getAuthorities());
        info.put("tokenAttributes", principal.getTokenAttributes());

        return info;
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return AuthService.login(authentication);
    }
}
