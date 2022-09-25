package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.ClienteDto;
import com.fatec.ordemservico.ordemservico.dto.ClienteUpdateDTO;
import com.fatec.ordemservico.ordemservico.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, componentModel = "spring")
public interface ClienteMapper {

    Cliente clienteDtoToCliente(ClienteDto clienteDto);

    @Mapping(target = "cliente.preferenciaPagamento", source = "dto.preferenciaPagamento")
    @Mapping(target = "cliente.telefone", source = "dto.telefone")
    @Mapping(target = "cliente.email", source = "dto.email")
    void clienteUpdateDtoToCliente(@MappingTarget Cliente cliente, ClienteUpdateDTO dto);

    ClienteDto clienteToClienteDto(Cliente cliente);

}
