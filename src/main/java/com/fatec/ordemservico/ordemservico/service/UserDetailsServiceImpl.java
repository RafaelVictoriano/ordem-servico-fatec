package com.fatec.ordemservico.ordemservico.service;

import com.fatec.ordemservico.ordemservico.dto.UserDto;
import com.fatec.ordemservico.ordemservico.dto.UserResponseDTO;
import com.fatec.ordemservico.ordemservico.mapper.UsuarioMapper;
import com.fatec.ordemservico.ordemservico.model.Usuario;
import com.fatec.ordemservico.ordemservico.repository.UsuarioRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private UsuarioMapper mapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Usuario usuario = repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));

        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
    }

    @Transactional
    public UserResponseDTO create(UserDto userDto) throws ValidationException {
        if (repository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new ValidationException("Usuario já existe!");
        }
        if (!userDto.getSenha().equals(userDto.getReSenha())) {
            throw new ValidationException("Senhas devem ser iguais!");
        }

        final var usuario = this.mapper.create(userDto);
        usuario.setSenha(new BCryptPasswordEncoder().encode(userDto.getSenha()));
        repository.save(usuario);
        return this.mapper.userToUserResponseDTO(usuario);
    }

    public Set<UserResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::userToUserResponseDTO)
                .collect(Collectors.toSet());
    }
}
