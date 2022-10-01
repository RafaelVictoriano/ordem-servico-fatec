package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
public class ServicoDto implements Serializable {
    private Long id;
    private String name;
    private BigDecimal valor;
}