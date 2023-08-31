package com.accenture.user.utils;

import java.util.Date;

import com.chale.user.dto.RoleDTO;
import com.chale.user.dto.UserDTO;
import com.chale.user.dto.UserRegisterDTO;
import com.chale.user.model.Role;
import com.chale.user.model.User;

public class UserUtils {

	public static User getUser() {
		User user = new User();
		user.setNombre("lucas");
		user.setApellido("chalela");
		user.setFechaAlta(new Date());
		user.setPais("Argentina");
		user.setActived(true);
		user.setRole( getRole() );
		user.setSexo("Masculino");
		user.setTelefono("1111222233");
		user.setUsername("lucaschalela");
		return user;
	}
	
	public static UserDTO getUserMockDTO() {
		UserDTO user = new UserDTO();
		user.setNombre("lucas");
		user.setApellido("chalela");
		user.setFechaAlta(new Date());
		user.setPais("Argentina");
		user.setActived(true);
		RoleDTO roleDTO  = new RoleDTO();
		roleDTO.setName("SCOPE_ROLE_USER");
		user.setRole( roleDTO );
		user.setSexo("Masculino");
		user.setTelefono("1111222233");
		user.setUsername("lucaschalela");
		return user;
	}
	
	public static RoleDTO roleDTOMock() {
		RoleDTO roleDTO  = new RoleDTO();
		roleDTO.setName("SCOPE_ROLE_USER");
		return roleDTO;
	}
	
	public static Role getRole() {
		Role role = new Role();
		role.setId(2L);
		role.setName("SCOPE_USER");
		return role;
	}
	
	public static UserRegisterDTO getUserDTO() {
		UserRegisterDTO user = new UserRegisterDTO();
		user.setNombre("lucas");
		user.setApellido("chalela");
		user.setPais("Argentina");
		user.setSexo("Masculino");
		user.setPassword("1234");
		user.setPassword2("1234");
		user.setUsername("lucaschalela");
		return user;
	}
	
}
