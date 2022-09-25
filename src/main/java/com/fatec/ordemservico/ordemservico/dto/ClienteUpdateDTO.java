package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ClienteUpdateDTO {

    private String preferenciaPagamento;
    private String telefone;
    private String email;
    private EnderecoDTO endereco;
}
