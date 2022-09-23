package com.fatec.ordemservico.ordemservico.controller;

import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import com.fatec.ordemservico.ordemservico.service.TermoGarantiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_FUNCIONARIO;
import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_GERENTE;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;

@CrossOrigin(allowedHeaders = "*", origins = "*", maxAge = 3600, methods = {POST, GET, PUT, OPTIONS})
@RequestMapping("/termo-garantia")
@RestController
public class TermoGarantiaController {

    @Autowired
    private TermoGarantiaService service;

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Validated TermoGarantiaDto termoGarantiaDto) {
        service.save(termoGarantiaDto);
    }


    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<TermoGarantiaDto>> getAll() {
        return ResponseEntity.ok(service.get());
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{id}")
    public ResponseEntity<TermoGarantia> findById(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }
}
