package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "termos_garantias")
public class TermoGarantia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tempo_garantia")
    private LocalDate tempoGarantia;

    private String titulo;

    @OneToOne(mappedBy = "termoGarantia")
    private OrdemServico ordemServico;


}