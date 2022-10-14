package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.fatec.ordemservico.ordemservico.model.TermoGarantia} entity
 */
@Data
public class TermoGarantiaResponseDto implements Serializable {
    private final Long id;
    private final LocalDate tempoGarantia;
    private final String titulo;
}