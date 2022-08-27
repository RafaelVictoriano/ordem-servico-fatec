package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.mapper.ClienteMapper;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ClienteService(ClienteRepository repository, ClienteMapper mapper) {


    public void save(final ClienteDto clienteDto) {
        final var cliente = mapper.clienteDtoToCliente(clienteDto);
        repository.save(cliente);
    }

    public List<Cliente> get() {
        return repository.findAll();
    }
}
