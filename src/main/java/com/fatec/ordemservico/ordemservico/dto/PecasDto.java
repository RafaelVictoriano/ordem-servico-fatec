package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class PecasDto implements Serializable {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String fabricante;
    @NotNull
    @Min(1)
    private Integer quantidade;
    @NotNull
    private BigDecimal valor;
    @NotEmpty
    private String fornecedor;
}
