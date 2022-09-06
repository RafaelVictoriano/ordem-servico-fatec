package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TermoGarantiaDto implements Serializable {

    private final LocalDate tempoGarantia;
    private final String clienteId;
    private final String servicoId;
}
