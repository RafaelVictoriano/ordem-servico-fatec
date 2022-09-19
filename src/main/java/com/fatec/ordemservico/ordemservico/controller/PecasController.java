package com.fatec.ordemservico.ordemservico.controller;

import com.fatec.ordemservico.ordemservico.dto.PecasDto;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import com.fatec.ordemservico.ordemservico.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_FUNCIONARIO;
import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_GERENTE;

@RequestMapping("/pecas")
@RestController
public class PecasController {

    @Autowired
    private PecaService service;

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Validated PecasDto pecasDto) {
        service.save(pecasDto);
    }


    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody PecasDto pecasDto) {
        service.update(id, pecasDto);
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<PecasDto>> getAll() {
        return ResponseEntity.ok(service.get());
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{id}")
    public ResponseEntity<Pecas> findById(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }
}
