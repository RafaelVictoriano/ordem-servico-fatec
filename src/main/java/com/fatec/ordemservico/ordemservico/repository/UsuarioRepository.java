package com.fatec.ordemservico.ordemservico.repository;

import com.fatec.ordemservico.ordemservico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
}