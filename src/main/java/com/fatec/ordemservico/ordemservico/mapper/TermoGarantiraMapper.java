package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.TermoGarantiaDto;
import com.fatec.ordemservico.ordemservico.model.TermoGarantia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TermoGarantiraMapper {


    @Mappings({
            @Mapping(target = "servico.id", source = "servicoId"),
            @Mapping(target = "cliente.id", source = "clienteId"),
    })
    TermoGarantia dtoToEntity(TermoGarantiaDto termoGarantiaDto);

    @Mappings({
            @Mapping(target = "servicoId", source = "servico.id"),
            @Mapping(target = "clienteId", source = "cliente.id"),
    })
    TermoGarantiaDto entityToDto(TermoGarantia termoGarantia);
}
