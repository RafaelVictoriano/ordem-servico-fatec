package com.fatec.ordemservico.ordemservico.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class OrcamentoPecasCompositeKey implements Serializable {

    private Long orcamento_id;
    private Long peca_id;
}
