package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.PecasDto;
import com.fatec.ordemservico.ordemservico.mapper.PecasMapper;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import com.fatec.ordemservico.ordemservico.repository.PecasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public record PecaService(PecasRepository repository, PecasMapper mapper) {

    public void save(final PecasDto pecasDto) {
        final var pecas = mapper.pecasDtoToPecas(pecasDto);
        repository.save(pecas);
    }

    public void update(final Long id, final PecasDto pecasDto) {
        findById(id)
                .ifPresentOrElse(peca -> {
                    Pecas pecas = mapper.updatePecasFromPecasDto(pecasDto, peca);
                    repository.save(peca);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Peca não econtrado");
                });
    }

    public List<PecasDto> get() {
        final var pecas = repository.findAll();
        return pecas.stream()
                .map(mapper::pecasToPecasDto)
                .collect(toList());
    }

    public Optional<Pecas> findById(Long id) {
        return repository.findById(id);
    }
}
