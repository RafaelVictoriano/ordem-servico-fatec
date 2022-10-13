package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.OrdemServicoDto;
import com.fatec.ordemservico.ordemservico.dto.OrdemServicoResponseDTO;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import com.fatec.ordemservico.ordemservico.model.Servico;
import org.aspectj.lang.annotation.After;
import org.mapstruct.*;

import java.util.List;

import static java.util.Objects.nonNull;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrdemServicoMapper {

    @Mappings({
            @Mapping(target = "cliente.id", source = "clienteId"),
    })
    OrdemServico ordemServicoDtoToOrdemServico(OrdemServicoDto ordemServicoDto);


    OrdemServicoResponseDTO ordemServicoToOrdemServicoDto(OrdemServico ordemServico);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "termoGarantia.id", source = "termoGarantiaId")
    OrdemServico updateOrdemServicoFromOrdemServicoDto(OrdemServicoDto ordemServicoDto, @MappingTarget OrdemServico ordemServico);


    @AfterMapping
    default void afterOrdemServicoDtoToOrdemServico(@MappingTarget OrdemServico ordemServico,
                                                    OrdemServicoDto ordemServicoDto) {
        if (nonNull(ordemServicoDto.getServicosId())) {
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
}
