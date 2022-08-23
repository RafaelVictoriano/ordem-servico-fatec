package com.fatec.ordemservico.ordemservico.repository;

import com.fatec.ordemservico.ordemservico.model.Pecas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecasRepository extends JpaRepository<Pecas, Long> {
}