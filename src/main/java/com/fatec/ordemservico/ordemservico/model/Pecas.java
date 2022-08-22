package com.fatec.ordemservico.ordemservico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

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
}