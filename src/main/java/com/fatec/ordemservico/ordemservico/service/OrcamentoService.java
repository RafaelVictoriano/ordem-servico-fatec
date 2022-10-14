package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.OrcamentoDto;
import com.fatec.ordemservico.ordemservico.model.Orcamento;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import com.fatec.ordemservico.ordemservico.model.Servico;
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
    public Orcamento generate(final OrcamentoDto orcamentoDto) {
        final var ordemServico = ordemServicoService.findById(orcamentoDto.getOrdemServicoId());
        final var pecas = pecaService.findByIdInAndUpdateQuantity(orcamentoDto.getPecaIds());
        final var orcamento = new Orcamento();
        orcamento.setPecas(pecas);
        orcamento.setOrdemServico(ordemServico);
        orcamento.setValorTotal(getTotalValue(pecas, ordemServico));
        return repository.save(orcamento);
    }

    private BigDecimal getTotalValue(List<Pecas> pecas, OrdemServico ordemServico) {
        final var totalValuePecas = getSum(pecas.stream().map(Pecas::getValor).toList());
        final var servicosValues = getSum(ordemServico.getServicos().stream()
                .map(Servico::getValor)
                .toList());

        return totalValuePecas.add(servicosValues);
    }

    private BigDecimal getSum(List<BigDecimal> number) {
        return BigDecimal.valueOf(number.stream()
                .mapToDouble(BigDecimal::doubleValue)
                .sum());
    }
}
