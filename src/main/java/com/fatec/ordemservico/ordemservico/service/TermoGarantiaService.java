package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.OrdemServicoDto;
import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.mapper.TermoGarantiraMapper;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import com.fatec.ordemservico.ordemservico.repository.TermoGarantiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class TermoGarantiaService {
    @Autowired
    private TermoGarantiraMapper mapper;
    @Autowired
    private TermoGarantiaRepository repository;
    @Autowired
    private OrderServicoService orderServicoService;

    @Transactional
    public void save(final TermoGarantiaDto termoGarantiaDto) {
        final var termoGarantia = mapper.dtoToEntity(termoGarantiaDto);
        repository.save(termoGarantia);
        OrdemServicoDto ordemServicoDto = new OrdemServicoDto();
        ordemServicoDto.setTermoGarantiaId(termoGarantia.getId());
        orderServicoService.update(termoGarantiaDto.getOrdemServicoId(), ordemServicoDto);
    }

    public List<TermoGarantiaDto> get() {
        final var pecas = repository.findAll();
        return pecas.stream()
                .map(mapper::entityToDto)
                .collect(toList());
    }

    public Optional<TermoGarantia> findById(Long id) {
        return repository.findById(id);
    }


}