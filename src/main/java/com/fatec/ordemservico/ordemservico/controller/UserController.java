package com.fatec.ordemservico.ordemservico.controller;


import com.fatec.ordemservico.ordemservico.dto.UserDto;
import com.fatec.ordemservico.ordemservico.dto.UserResponseDTO;
import com.fatec.ordemservico.ordemservico.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.xml.bind.ValidationException;
import java.util.Set;

import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_GERENTE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(allowedHeaders = "*", originPatterns = "*", maxAge = 3600, methods = {POST, GET, PUT, OPTIONS}, allowCredentials = "true")
@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;


    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed(ROLES_GERENTE)
    @PostMapping()
    public UserResponseDTO register(@RequestBody UserDto request) throws ValidationException {
        return userDetailsServiceImpl.create(request);
    }

    @GetMapping()
    public Set<UserResponseDTO> findAll() throws ValidationException {
        return userDetailsServiceImpl.findAll();
    }

}

