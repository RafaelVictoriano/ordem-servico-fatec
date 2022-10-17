package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fatec.ordemservico.ordemservico.enumerations.RoleName;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto implements Serializable {
    @NotNull @Email @NotEmpty
    private String email;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String senha;
    @NotEmpty
    private String reSenha;
    @NotNull @CPF
    private String cpf;
    @NotNull
    private Long telefone;
    @NotNull
    private RoleName perfil;

    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getReSenha() {
        return reSenha;
    }

    public void setReSenha(String reSenha) {
        this.reSenha = reSenha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public RoleName getPerfil() {
        return perfil;
    }

    public void setPerfil(RoleName perfil) {
        this.perfil = perfil;
    }
}
