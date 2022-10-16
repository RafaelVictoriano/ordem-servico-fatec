package com.fatec.ordemservico.ordemservico.controller;

import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaResponseDto;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import com.fatec.ordemservico.ordemservico.service.TermoGarantiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_FUNCIONARIO;
import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_GERENTE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(allowedHeaders = "*", origins = "*", maxAge = 3600, methods = {POST, GET, PUT, OPTIONS})
@RequestMapping("/termo-garantia")
@RestController
public class TermoGarantiaController {

    @Autowired
    private TermoGarantiaService service;

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<TermoGarantiaResponseDto>> getAll() {
        return ResponseEntity.ok(service.get());
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{id}")
    public ResponseEntity<TermoGarantiaResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
