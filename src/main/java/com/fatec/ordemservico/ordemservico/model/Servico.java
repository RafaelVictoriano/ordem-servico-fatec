package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private BigDecimal valor;

    @ManyToMany(mappedBy = "servicos")
    private List<OrdemServico> ordemServicos;

}