package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.dto.ClienteUpdateDTO;
import com.fatec.ordemservico.ordemservico.mapper.ClienteMapper;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public record ClienteService(ClienteRepository repository, ClienteMapper mapper) {


    public void save(final ClienteDto clienteDto) {
        final var cliente = mapper.clienteDtoToCliente(clienteDto);
        repository.save(cliente);
    }

    public void update(final Long id, final ClienteUpdateDTO clienteUpdateDTO) {
        findById(id)
                .ifPresentOrElse(cliente -> {
                    mapper.clienteUpdateDtoToCliente(cliente, clienteUpdateDTO);
                    repository.save(cliente);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não econtrado");
                });
    }

    public List<ClienteDto> get() {
        final var clientes = repository.findAll();
        return clientes.stream()
                .map(mapper::clienteToClienteDto)
                .collect(toList());
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }
}

