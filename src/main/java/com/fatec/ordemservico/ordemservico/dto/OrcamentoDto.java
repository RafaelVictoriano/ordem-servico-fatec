package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
public class OrcamentoDto implements Serializable {
    private Long ordemServicoId;
    private List<Long> pecaIds;
}