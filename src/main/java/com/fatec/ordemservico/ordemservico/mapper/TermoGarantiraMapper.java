package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TermoGarantiraMapper {


    TermoGarantia dtoToEntity(TermoGarantiaDto termoGarantiaDto);

    TermoGarantiaDto entityToDto(TermoGarantia termoGarantia);
}
