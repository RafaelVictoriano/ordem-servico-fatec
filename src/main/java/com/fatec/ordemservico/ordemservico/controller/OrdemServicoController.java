package com.fatec.ordemservico.ordemservico.controller;

import com.fatec.ordemservico.ordemservico.dto.OrdemServicoDto;
import com.fatec.ordemservico.ordemservico.dto.OrdemServicoResponseDTO;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.service.OrderServicoService;
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
@RequestMapping("/ordem-servico")
@RestController
public class OrdemServicoController {

    @Autowired
    private OrderServicoService service;

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Validated OrdemServicoDto ordemServicoDto) {
        service.save(ordemServicoDto);
    }


    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody OrdemServicoDto ordemServicoDto) {
        service.update(id, ordemServicoDto);
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<OrdemServicoResponseDTO>> getAll() {
        return ResponseEntity.of(service.get());
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServicoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
