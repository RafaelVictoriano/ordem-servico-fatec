package com.fatec.ordemservico.ordemservico;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.model.Role;
import com.fatec.ordemservico.ordemservico.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import java.util.List;

import static com.fatec.ordemservico.ordemservico.enumerations.RoleName.ROLES_FUNCIONARIO;

@RequestMapping("/cliente")
@RestController
public record Controller(ClienteService clienteService) {

    @ResponseStatus(HttpStatus.CREATED)
    @RolesAllowed({Role.ROLES_FUNCIONARIO, Role.ROLES_GERENTE})
    @PostMapping
    public void save(@RequestBody @Valid ClienteDto clienteDto) {
        clienteService.save(clienteDto);
    }

    @RolesAllowed({Role.ROLES_FUNCIONARIO, Role.ROLES_GERENTE})
    @GetMapping
    public ResponseEntity<List<Cliente>>getAll() {
      return ResponseEntity.ok(clienteService.get());
    }
}
