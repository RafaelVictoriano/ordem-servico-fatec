package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.EnderecoDTO;
import com.fatec.ordemservico.ordemservico.model.Endereco;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EnderecoMapper {
    Endereco enderecoDTOToEndereco(EnderecoDTO enderecoDTO);

    EnderecoDTO enderecoToEnderecoDTO(Endereco endereco);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Endereco updateEnderecoFromEnderecoDTO(EnderecoDTO enderecoDTO, @MappingTarget Endereco endereco);
}
