package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.EnderecoDTO;
import com.fatec.ordemservico.ordemservico.mapper.EnderecoMapper;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import com.fatec.ordemservico.ordemservico.model.Endereco;
import com.fatec.ordemservico.ordemservico.repository.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public record EnderecoService(EnderecoRepository repository, EnderecoMapper mapper) {

    public void save(final EnderecoDTO enderecoDTO, final Cliente cliente) {
        final var endereco = mapper.enderecoDTOToEndereco(enderecoDTO);
        endereco.setCliente(cliente);
        repository.save(endereco);
    }

    public void update(final EnderecoDTO enderecoDTO, final Endereco endereco) {
       repository.save(mapper.updateEnderecoFromEnderecoDTO(enderecoDTO, endereco));
    }

    public Optional<List<EnderecoDTO>> get() {
        final var pecas = repository.findAll();
        return Optional.of(pecas.stream()
                .map(mapper::enderecoToEnderecoDTO)
                .collect(toList()))
                .filter(enderecoDTOS -> !enderecoDTOS.isEmpty());
    }

    public Optional<Endereco> findById(Long id) {
        return repository.findById(id);
    }
}
