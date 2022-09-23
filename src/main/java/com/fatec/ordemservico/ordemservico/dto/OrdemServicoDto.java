package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class OrdemServicoDto implements Serializable {

    @NotEmpty
    private String clienteId;
    @NotBlank
    private String nome;
    @NotBlank
    private String equipamento;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal valor;
}
