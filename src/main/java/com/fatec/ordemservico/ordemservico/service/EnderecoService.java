package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.EnderecoDTO;
import com.fatec.ordemservico.ordemservico.mapper.EnderecoMapper;
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

    public void save(final EnderecoDTO enderecoDTO) {
        repository.save(mapper.enderecoDTOToEndereco(enderecoDTO));
    }

    public void update(final Long id, final EnderecoDTO enderecoDTO) {
        findById(id)
                .ifPresentOrElse(e -> repository.save(mapper.updateEnderecoFromEnderecoDTO(enderecoDTO, e))
                        , () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não econtrado");
                        });
    }

    public Optional<List<EnderecoDTO>> get() {
        final var pecas = repository.findAll();
        return Optional.of(pecas.stream()
                .map(mapper::enderecoToEnderecoDTO)
                .collect(toList()));
    }

    public Optional<Endereco> findById(Long id) {
        return repository.findById(id);
    }
}
