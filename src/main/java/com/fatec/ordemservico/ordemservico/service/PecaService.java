package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.PecasDto;
import com.fatec.ordemservico.ordemservico.mapper.PecasMapper;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import com.fatec.ordemservico.ordemservico.repository.PecasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public record PecaService(PecasRepository repository, PecasMapper mapper) {

    public void save(final PecasDto pecasDto) {
        final var pecas = mapper.pecasDtoToPecas(pecasDto);
        repository.save(pecas);
    }

    public void update(final Long id, final PecasDto pecasDto) {
        findById(id)
                .ifPresentOrElse(peca -> {
                    final var pecas = mapper.updatePecasFromPecasDto(pecasDto, peca);
                    repository.save(pecas);
                }, () -> {
                    throw new ResponseStatusException(NOT_FOUND, "Peca não econtrado");
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

    public List<Pecas> findByIdInAndUpdateQuantity(List<Long> ids) {
        final var pecas = Optional.of(repository.findByIdIn(ids)
                        .stream()
                        .flatMap(Collection::stream)
                        .filter(p -> p.getQuantidade() > 0)
                        .toList())
                .filter(not(List::isEmpty))
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND, "Nâo foi encontrada a peça com quantidade dispónivel"));

        pecas.forEach(p -> p.setQuantidade(p.getQuantidade() - 1));
        repository.saveAll(pecas);
        return pecas;
    }

}
