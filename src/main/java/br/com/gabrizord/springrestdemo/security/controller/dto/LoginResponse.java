package br.com.gabrizord.springrestdemo.security.controller.dto;

public record LoginResponse(String accessToken, long expiresIn) {
}
