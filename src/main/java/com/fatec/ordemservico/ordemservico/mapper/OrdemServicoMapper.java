package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.OrdemServicoDto;
import com.fatec.ordemservico.ordemservico.model.OrdemServico;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrdemServicoMapper {

    @Mappings({
            @Mapping(target = "servico.id", source = "servicoId"),
            @Mapping(target = "cliente.id", source = "clienteId"),
    })
    OrdemServico ordemServicoDtoToOrdemServico(OrdemServicoDto ordemServicoDto);

    @Mappings({
            @Mapping(target = "servicoId", source = "servico.id"),
            @Mapping(target = "clienteId", source = "cliente.id"),
    })
    OrdemServicoDto ordemServicoToOrdemServicoDto(OrdemServico ordemServico);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrdemServico updateOrdemServicoFromOrdemServicoDto(OrdemServicoDto ordemServicoDto, @MappingTarget OrdemServico ordemServico);
}
