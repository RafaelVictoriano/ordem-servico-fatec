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

    @OneToOne(mappedBy = "ordemServico")
    private Orcamento orcamento;

    @ManyToMany()
    @JoinTable(name = "servico_os",
            joinColumns = @JoinColumn(name = "os_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private List<Servico> servicos;

    @PrePersist
    private void prePersisit() {
        dateEmissao = LocalDate.now();
    }



}