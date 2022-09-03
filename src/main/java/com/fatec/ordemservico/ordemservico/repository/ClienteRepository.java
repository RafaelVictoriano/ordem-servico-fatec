package com.fatec.ordemservico.ordemservico.repository;

import com.fatec.ordemservico.ordemservico.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}