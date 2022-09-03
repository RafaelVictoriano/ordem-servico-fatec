package com.fatec.ordemservico.ordemservico.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClienteDto implements Serializable {

    @NotNull
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String preferenciaPagamento;
    @NotNull
    private String cep;
    @NotNull
    private String telefone;
    @NotNull
    @Email
    private String email;
}
