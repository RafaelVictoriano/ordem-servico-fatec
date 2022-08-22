package com.fatec.ordemservico.ordemservico.model;

import javax.persistence.*;
import java.math.BigDecimal;

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

    private BigDecimal valorTotalPagar;



}