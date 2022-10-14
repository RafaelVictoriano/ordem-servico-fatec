package com.fatec.ordemservico.ordemservico.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class OrdemServicoResponseDTO implements Serializable {
    private Long id;
    private String tipoEquipameto;
    private String descricao;
    private ClienteDto cliente;
    private LocalDate dateEmissao;
    private TermoGarantiaResponseDto termoGarantia;
    private OrcamentoResponseDto orcamento;
    private List<ServicoDto> servicos;
}