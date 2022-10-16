package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseDTO implements Serializable {
    private final String email;
    private final String nome;

    private final String perfil;


    public UserResponseDTO(String email, String nome, String perfil) {
        this.email = email;
        this.nome = nome;
        this.perfil = perfil;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return perfil;
    }
}
