package com.fatec.ordemservico.ordemservico.model;

import com.fatec.ordemservico.ordemservico.enumerations.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Perfil implements GrantedAuthority {

    public static final String ROLES_GERENTE = "ROLES_GERENTE";
    public static final String ROLES_FUNCIONARIO = "ROLES_FUNCIONARIO";
    public static final String ROLES_CLIENTE = "ROLES_CLIENTE";

    @Id
    @Enumerated(EnumType.STRING)
    private RoleName nome;

    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;

    public Perfil() {
    }


    public RoleName getNome() {
        return nome;
    }

    public void setNome(RoleName nome) {
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome.toString();
    }
}
