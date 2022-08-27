package com.fatec.ordemservico.ordemservico.model;

import com.fatec.ordemservico.ordemservico.enumerations.RoleName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

    public static final String ROLES_GERENTE = "ROLES_GERENTE";
    public static final String ROLES_FUNCIONARIO = "ROLES_FUNCIONARIO";
    public static final String ROLES_CLIENTE = "ROLES_CLIENTE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.toString();
    }
}
