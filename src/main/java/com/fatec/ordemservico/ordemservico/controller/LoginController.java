package com.fatec.ordemservico.ordemservico.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @PostMapping("login")
    public ResponseEntity<Void> login(Authentication auth) {
        return ResponseEntity.ok().build();
    }
}
