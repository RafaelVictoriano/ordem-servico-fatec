package com.fatec.ordemservico.ordemservico.repository;

import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}