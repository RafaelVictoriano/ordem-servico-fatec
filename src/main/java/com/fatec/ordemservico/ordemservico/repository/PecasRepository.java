package com.fatec.ordemservico.ordemservico.repository;

import com.fatec.ordemservico.ordemservico.model.Pecas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PecasRepository extends JpaRepository<Pecas, Long> {

    Optional<List<Pecas>> findByIdIn(List<Long> ids);
}