package com.chale.user.mapper;

import com.chale.user.dto.RoleDTO;
import com.chale.user.dto.UserDTO;
import com.chale.user.dto.UserRegisterDTO;
import com.chale.user.model.Role;
import com.chale.user.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-31T11:24:09-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userRegisterTOUser(UserRegisterDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setApellido( userDTO.getApellido() );
        user.setNombre( userDTO.getNombre() );
        user.setPais( userDTO.getPais() );
        user.setPassword( userDTO.getPassword() );
        user.setSexo( userDTO.getSexo() );
        user.setUsername( userDTO.getUsername() );

        return user;
    }

    @Override
    public UserDTO userTOUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setActived( user.isActived() );
        userDTO.setApellido( user.getApellido() );
        userDTO.setFechaAlta( user.getFechaAlta() );
        userDTO.setNombre( user.getNombre() );
        userDTO.setPais( user.getPais() );
        userDTO.setRole( roleDTO( user.getRole() ) );
        userDTO.setSexo( user.getSexo() );
        userDTO.setTelefono( user.getTelefono() );
        userDTO.setUsername( user.getUsername() );

        return userDTO;
    }

    @Override
    public RoleDTO roleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setName( role.getName() );

        return roleDTO;
    }
}
