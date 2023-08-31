package com.chale.user.mapper;

import org.mapstruct.Mapper;

import com.chale.user.dto.RoleDTO;
import com.chale.user.dto.UserDTO;
import com.chale.user.dto.UserRegisterDTO;
import com.chale.user.model.Role;
import com.chale.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User userRegisterTOUser(UserRegisterDTO userDTO);
	UserDTO userTOUserDTO(User user);
	RoleDTO roleDTO(Role role);
}
