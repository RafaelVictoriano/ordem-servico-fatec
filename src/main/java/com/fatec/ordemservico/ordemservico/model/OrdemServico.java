package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "tipo_equipamento")
    private String tipoEquipameto;

    private String descricao;
    @ManyToOne
    private Cliente cliente;

    @Column(name = "data_emissao")
    private LocalDate dateEmissao;

    @OneToOne
    private TermoGarantia termoGarantia;

    private BigDecimal valor;

    @OneToOne(mappedBy = "ordemServico")
    private Orcamento orcamento;

    @PrePersist
    private void prePersisit() {
        dateEmissao = LocalDate.now();
    }



}