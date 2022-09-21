package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pecas")
public class Pecas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String fabricante;
    private Integer quantidade;
    private BigDecimal valor;
    private String fornecedor;

    @ManyToMany
    @JoinTable(name = "orcamento_pecas",
            joinColumns = @JoinColumn(name = "orcamento_id"),
            inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<Orcamento> orcamento;
}