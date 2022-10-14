package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaResponseDto;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TermoGarantiraMapper {


    TermoGarantia dtoToEntity(TermoGarantiaDto termoGarantiaDto);

    TermoGarantiaDto entityToDto(TermoGarantia termoGarantia);

    TermoGarantia termoGarantiaDto1ToTermoGarantia(TermoGarantiaResponseDto termoGarantiaResponseDto);

    TermoGarantiaResponseDto termoGarantiaToTermoGarantiaDto1(TermoGarantia termoGarantia);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TermoGarantia updateTermoGarantiaFromTermoGarantiaDto1(TermoGarantiaResponseDto termoGarantiaResponseDto, @MappingTarget TermoGarantia termoGarantia);
}
