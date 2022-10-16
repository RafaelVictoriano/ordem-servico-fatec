package com.fatec.ordemservico.ordemservico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrdemServicoDto implements Serializable {

    private Long id;
    @NotEmpty
    private String clienteId;
    @NotBlank
    private String tipoEquipameto;
    @NotBlank
    private String descricao;

    private List<Long> servicosId;

    private TermoGarantiaDto termoGarantia;
}
