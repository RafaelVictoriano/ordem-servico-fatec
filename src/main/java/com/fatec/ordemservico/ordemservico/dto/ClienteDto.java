package com.fatec.ordemservico.ordemservico.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ClienteDto implements Serializable {

    @NotNull @CPF
    private final String cpf;
    @NotNull
    private final LocalDate dataNascimento;
    @NotNull
    private final String preferenciaPagamento;
    @NotNull
    private final String cep;
    @NotNull
    private final String telefone;
    @NotNull @Email
    private final String email;
}
