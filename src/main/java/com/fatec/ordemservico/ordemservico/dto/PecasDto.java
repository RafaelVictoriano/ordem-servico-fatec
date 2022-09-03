package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PecasDto implements Serializable {
    private final String nome;
    private final String fabricante;
    private final String quantidade;
    private final BigDecimal valor;
    private final String fornecedor;
}
