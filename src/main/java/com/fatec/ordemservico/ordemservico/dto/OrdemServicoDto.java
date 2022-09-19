package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrdemServicoDto implements Serializable {

    private final String clienteId;
    private final String nome;
    private final String tipoEquipamento;
    private final BigDecimal valorTotalPagar;
}
