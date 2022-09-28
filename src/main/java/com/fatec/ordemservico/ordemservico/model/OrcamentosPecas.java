package com.fatec.ordemservico.ordemservico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@IdClass(OrcamentoPecasCompositeKey.class)
@Table(name = "orcamento_pecas")
public class OrcamentosPecas {

    @Id
    private Long orcamento_id;

    @Id
    private Long peca_id;

}
