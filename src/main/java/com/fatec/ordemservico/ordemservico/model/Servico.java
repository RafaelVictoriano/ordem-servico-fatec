package com.fatec.ordemservico.ordemservico.model;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String nome;

    private BigDecimal preco;

    private String tipoEquipamento;

    @OneToMany(mappedBy = "servico")
    private List<TermoGarantia> termoGarantia;

    @OneToMany(mappedBy = "servico")
    private List<OrdemServico> ordemServico;



}