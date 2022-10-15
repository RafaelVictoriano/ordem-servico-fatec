package com.fatec.ordemservico.ordemservico.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
public class TermoGarantiaResponseDto implements Serializable {
    private Long id;
    private LocalDate tempoGarantia;
    private String titulo;
}