package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.ServicoDto;
import com.fatec.ordemservico.ordemservico.model.Servico;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ServicoMapper {
    Servico servicoDtoToServico(ServicoDto servicoDto);

    ServicoDto servicoToServicoDto(Servico servico);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Servico updateServicoFromServicoDto(ServicoDto servicoDto, @MappingTarget Servico servico);
}
