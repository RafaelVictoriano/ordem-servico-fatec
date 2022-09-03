package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pecas")
public class Pecas {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String fabricante;
    private String quantidade;
    private BigDecimal valor;
    private String fornecedor;

    @ManyToMany(mappedBy = "pecas")
    private List<OrdemServico> ordermServicos;
}