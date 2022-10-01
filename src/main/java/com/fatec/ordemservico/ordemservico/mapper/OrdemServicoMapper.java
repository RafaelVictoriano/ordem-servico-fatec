package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.OrdemServicoDto;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.model.Servico;
import org.aspectj.lang.annotation.After;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrdemServicoMapper {

    @Mappings({
            @Mapping(target = "cliente.id", source = "clienteId"),
    })
    OrdemServico ordemServicoDtoToOrdemServico(OrdemServicoDto ordemServicoDto);

    @Mappings({
            @Mapping(target = "clienteId", source = "cliente.id"),
    })
    OrdemServicoDto ordemServicoToOrdemServicoDto(OrdemServico ordemServico);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrdemServico updateOrdemServicoFromOrdemServicoDto(OrdemServicoDto ordemServicoDto, @MappingTarget OrdemServico ordemServico);


    @AfterMapping
    default void afterOrdemServicoDtoToOrdemServico(@MappingTarget OrdemServico ordemServico,
                                                    OrdemServicoDto ordemServicoDto) {
      final var servicos = ordemServicoDto
                .getServicosId()
                .stream()
                .map(id -> {
                    final var servico = new Servico();
                    servico.setId(id);
                    return servico;
                }).toList();
      ordemServico.setServicos(servicos);
    }
}
