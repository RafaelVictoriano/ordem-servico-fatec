package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.OrcamentoDto;
import com.fatec.ordemservico.ordemservico.model.Orcamento;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import com.fatec.ordemservico.ordemservico.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrderServicoService ordemServicoService;
    @Autowired
    private PecaService pecaService;
    @Autowired
    private OrcamentoRepository repository;

    @Transactional
    public Orcamento generate(OrcamentoDto orcamentoDto) {
        final var ordemServico = ordemServicoService.findById(orcamentoDto.getOrdemServicoId());
        final var pecas = pecaService.findByIdIn(orcamentoDto.getPecaIds());
        final var orcamento = new Orcamento();
        orcamento.setPecas(pecas);
        orcamento.setOrdemServico(ordemServico);
        orcamento.setValorTotal(getTotalValue(pecas, ordemServico));
        return repository.save(orcamento);
    }

    private BigDecimal getTotalValue(List<Pecas> pecas, OrdemServico ordemServico) {
        final var totalValuePecas = pecas.stream()
                .mapToDouble(p -> p.getValor().doubleValue())
                .sum();
        return ordemServico.getValor().add(BigDecimal.valueOf(totalValuePecas));
    }
}
