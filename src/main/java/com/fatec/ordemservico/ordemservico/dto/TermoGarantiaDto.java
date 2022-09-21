package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TermoGarantiaDto implements Serializable {

    @NotBlank
    private String titulo;
    @NotNull
    private LocalDate tempoGarantia;
}
