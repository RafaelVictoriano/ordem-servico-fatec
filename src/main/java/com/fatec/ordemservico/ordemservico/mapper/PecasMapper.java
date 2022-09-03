package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.PecasDto;
import com.fatec.ordemservico.ordemservico.model.Pecas;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PecasMapper {
    Pecas pecasDtoToPecas(PecasDto pecasDto);

    PecasDto pecasToPecasDto(Pecas pecas);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pecas updatePecasFromPecasDto(PecasDto pecasDto, @MappingTarget Pecas pecas);
}
