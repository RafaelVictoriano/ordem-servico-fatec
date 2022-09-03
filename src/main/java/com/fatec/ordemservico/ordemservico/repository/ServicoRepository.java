package com.fatec.ordemservico.ordemservico.repository;

import com.fatec.ordemservico.ordemservico.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}