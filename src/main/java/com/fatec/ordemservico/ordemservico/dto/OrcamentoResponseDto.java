package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class OrcamentoResponseDto implements Serializable {

    private BigDecimal valorTotal;
    private List<PecasDto> pecas;
}