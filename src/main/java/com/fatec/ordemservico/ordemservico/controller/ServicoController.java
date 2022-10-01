package com.fatec.ordemservico.ordemservico.controller;

import com.fatec.ordemservico.ordemservico.dto.ServicoDto;
import com.fatec.ordemservico.ordemservico.service.ServicoService;
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

@CrossOrigin(allowedHeaders = "*", origins = "*", maxAge = 3600, methods = {POST, GET, PUT, OPTIONS})
@RequestMapping("/servico")
@RestController
public class ServicoController {

    @Autowired
    private ServicoService service;

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Validated ServicoDto servicoDto) {
        service.save(servicoDto);
    }


    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ServicoDto servicoDto) {
        service.update(id, servicoDto);
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<ServicoDto>> getAll() {
        return ResponseEntity.of(service.get());
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{id}")
    public ResponseEntity<ServicoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
