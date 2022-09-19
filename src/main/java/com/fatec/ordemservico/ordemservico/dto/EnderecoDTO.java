package com.fatec.ordemservico.ordemservico.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EnderecoDTO implements Serializable {
    private final Integer cep;
    private final String logradouro;
    private final String bairro;
    private final String cidade;
    private final String estado;
    private final String complemento;
    private final Integer numero;
    private final String clienteId;
}