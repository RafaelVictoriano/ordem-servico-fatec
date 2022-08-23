package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    ClienteDto clienteToClienteDto(Cliente cliente);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cliente updateClienteFromClienteDto(ClienteDto clienteDto, @MappingTarget Cliente cliente);
}
