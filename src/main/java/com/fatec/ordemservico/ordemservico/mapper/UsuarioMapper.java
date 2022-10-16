package com.fatec.ordemservico.ordemservico.mapper;

import com.fatec.ordemservico.ordemservico.dto.UserDto;
import com.fatec.ordemservico.ordemservico.dto.UserResponseDTO;
import com.fatec.ordemservico.ordemservico.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "perfil.nome", source = "perfil")
    Usuario create(UserDto userDto);

    @Mapping(target = "perfil", source = "perfil.nome")
    UserResponseDTO userToUserResponseDTO(Usuario usuario);

}
