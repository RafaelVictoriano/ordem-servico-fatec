package com.fatec.ordemservico.ordemservico;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.model.Role;
import com.fatec.ordemservico.ordemservico.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

import static com.fatec.ordemservico.ordemservico.model.Role.ROLES_FUNCIONARIO;
import static com.fatec.ordemservico.ordemservico.model.Role.ROLES_GERENTE;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Valid ClienteDto clienteDto) {
        clienteService.save(clienteDto);
    }

    @RolesAllowed({ROLES_FUNCIONARIO, ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.get());
    }
}
