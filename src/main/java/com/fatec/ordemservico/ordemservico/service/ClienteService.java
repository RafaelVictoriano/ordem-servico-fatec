package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.dto.ClienteUpdateDTO;
import com.fatec.ordemservico.ordemservico.mapper.ClienteMapper;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteMapper mapper;
    @Autowired
    private EnderecoService enderecoService;

    public void save(final ClienteDto clienteDto) {
        final var cliente = mapper.clienteDtoToCliente(clienteDto);
        repository.save(cliente);
        enderecoService.save(clienteDto.getEndereco(), cliente);
    }

    public void update(final Long id, final ClienteUpdateDTO clienteUpdateDTO) {
        findById(id)
                .ifPresentOrElse(cliente -> {
                    mapper.clienteUpdateDtoToCliente(cliente, clienteUpdateDTO);
                    repository.save(cliente);
                    if (nonNull(clienteUpdateDTO.getEndereco())) {
                        enderecoService.update(clienteUpdateDTO.getEndereco(), cliente.getEndereco());
                    }
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não econtrado");
                });
    }

    public Optional<List<ClienteDto>> get() {
        final var clientes = repository.findAll();
        return Optional.of(clientes.stream()
                        .map(mapper::clienteToClienteDto)
                        .collect(toList()))
                .filter(clienteDtos -> !clienteDtos.isEmpty());
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<ClienteDto> findByCpf(String id) {
        return repository.findByCpf(id)
                .map(mapper::clienteToClienteDto);
    }
}

