package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.ServicoDto;
import com.fatec.ordemservico.ordemservico.mapper.ServicoMapper;
import com.fatec.ordemservico.ordemservico.model.Servico;
import com.fatec.ordemservico.ordemservico.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public record ServicoService(ServicoRepository repository, ServicoMapper mapper) {

    public void save(final ServicoDto servicoDto) {
        repository.save(mapper.servicoDtoToServico(servicoDto));
    }

    public void update(final Long id, final ServicoDto servicoDto) {
        repository.save(mapper.updateServicoFromServicoDto(servicoDto, findById(id)));
    }

    public Optional<List<ServicoDto>> get() {
        return Optional.of(repository.findAll()
                .stream()
                .map(mapper::servicoToServicoDto)
                .collect(toList()));
    }

    public ServicoDto getById(final Long id) {
        return mapper.servicoToServicoDto(findById(id));
    }

    private Servico findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Servico não encontrada"));
    }
}
