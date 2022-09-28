package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.OrdemServicoDto;
import com.fatec.ordemservico.ordemservico.dto.PecasDto;
import com.fatec.ordemservico.ordemservico.mapper.OrdemServicoMapper;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import com.fatec.ordemservico.ordemservico.repository.OrdemServicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public record OrderServicoService(OrdemServicoRepository repository, OrdemServicoMapper mapper) {

    public void save(final OrdemServicoDto ordemServicoDto) {
        repository.save(mapper.ordemServicoDtoToOrdemServico(ordemServicoDto));
    }

    public void update(final Long id, final OrdemServicoDto ordemServicoDto) {
        final var ordermServico = findById(id);
        repository.save(mapper.updateOrdemServicoFromOrdemServicoDto(ordemServicoDto, ordermServico));
    }

    public Optional<List<OrdemServicoDto>> get() {
        final var pecas = repository.findAll();
        return Optional.of(pecas.stream()
                .map(mapper::ordemServicoToOrdemServicoDto)
                .collect(toList()));
    }

    public OrdemServico findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordem de Servico não encontrada"));
    }
}
