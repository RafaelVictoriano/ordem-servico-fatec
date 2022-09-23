package com.fatec.ordemservico.ordemservico.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto implements Serializable {

    @NotNull
    @CPF()
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private String preferenciaPagamento;
    @NotNull
    @Length(min = 8, max = 8)
    private String cep;
    @NotNull
    @Length(min = 9)
    private String telefone;
    @NotNull
    @Email()
    private String email;
    @NotNull
    @Valid
    private EnderecoDTO endereco;
}
