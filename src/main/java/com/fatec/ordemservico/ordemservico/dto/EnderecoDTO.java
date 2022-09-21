package com.fatec.ordemservico.ordemservico.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class EnderecoDTO implements Serializable {
    private Integer cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private Integer numero;
    private String clienteId;
}