package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Servico servico;

    @ManyToMany
    private List<Pecas> pecas;

    private BigDecimal valorTotalPagar;



}