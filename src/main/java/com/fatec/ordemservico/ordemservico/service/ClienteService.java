package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.mapper.ClienteMapper;
import com.fatec.ordemservico.ordemservico.repository.ClienteRepository;

public record ClienteService(ClienteRepository repository, ClienteMapper mapper) {


    public void save(final ClienteDto clienteDto) {
        final var cliente = mapper.clienteDtoToCliente(clienteDto);
        repository.save(cliente);
    }
}
