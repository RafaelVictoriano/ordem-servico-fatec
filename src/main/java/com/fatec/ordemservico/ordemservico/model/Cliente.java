package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cliente",
indexes = {
        @Index(name = "cpf_index", columnList = "cpf")
})
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "preferencia_pagamento")
    private String preferenciaPagamento;

    private String telefone;

    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<OrdemServico> ordemServico;
    
    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;

    public Cliente() {
    }
}