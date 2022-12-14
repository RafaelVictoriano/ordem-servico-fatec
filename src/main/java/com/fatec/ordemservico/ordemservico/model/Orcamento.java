package com.fatec.ordemservico.ordemservico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(unique = true)
    @OneToOne()
    private OrdemServico ordemServico;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToMany()
    @JoinTable(name = "orcamento_pecas",
            joinColumns = @JoinColumn(name = "orcamento_id"),
            inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<Pecas> pecas;

}