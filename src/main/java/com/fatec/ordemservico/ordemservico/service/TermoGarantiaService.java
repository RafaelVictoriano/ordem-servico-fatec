package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaResponseDto;
import com.fatec.ordemservico.ordemservico.mapper.TermoGarantiraMapper;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import com.fatec.ordemservico.ordemservico.repository.TermoGarantiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TermoGarantiaService {
    @Autowired
    private TermoGarantiraMapper mapper;
    @Autowired
    private TermoGarantiaRepository repository;

    public TermoGarantia save(final TermoGarantiaDto termoGarantiaDto) {
        final var termoGarantia = mapper.dtoToEntity(termoGarantiaDto);
        return repository.save(termoGarantia);
    }

    public List<TermoGarantiaResponseDto> get() {
        final var pecas = repository.findAll();
        return pecas.stream()
                .map(mapper::entityToDto)
                .collect(toList());
    }

    public TermoGarantiaResponseDto findById(Long id) {
        return mapper.entityToDto(repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Termo de garantia não encontrado")));
    }


}