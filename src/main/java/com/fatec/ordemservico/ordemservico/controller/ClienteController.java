package com.fatec.ordemservico.ordemservico.controller;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.dto.ClienteUpdateDTO;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_FUNCIONARIO;
import static com.fatec.ordemservico.ordemservico.model.Perfil.ROLES_GERENTE;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Validated ClienteDto clienteDto) {
        clienteService.save(clienteDto);
    }


    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteDto) {
        clienteService.update(id, clienteDto);
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<ClienteDto>> getAll() {
        return ResponseEntity.ok(clienteService.get());
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return ResponseEntity.of(clienteService.findById(id));
    }
}
