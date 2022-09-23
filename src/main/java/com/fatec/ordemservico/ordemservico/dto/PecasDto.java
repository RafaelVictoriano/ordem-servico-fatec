package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PecasDto implements Serializable {

    private Long id;

    @NotBlank
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
