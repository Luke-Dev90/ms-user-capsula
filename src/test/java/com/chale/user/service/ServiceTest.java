package com.chale.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accenture.user.utils.UserUtils;
import com.chale.user.dto.UserDTO;
import com.chale.user.mapper.UserMapper;
import com.chale.user.model.User;
import com.chale.user.repository.RoleRepository;
import com.chale.user.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	@Mock
	private UserMapper mapper;
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	void getUserByUsername(){
		Optional<User> user = Optional.of(UserUtils.getUser());
		when(userRepository.findByUsername("lucaschalela")).thenReturn( user);	
		when(mapper.userTOUserDTO(user.get())).thenReturn(UserUtils.getUserMockDTO());
		when(mapper.roleDTO(user.get().getRole())).thenReturn( UserUtils.roleDTOMock());
		UserDTO respService = this.userService.getUserByUsername("lucaschalela");
		assertThat(respService.getUsername()).isEqualTo("lucaschalela");
		assertThat(respService.getRole().getName()).isEqualTo("SCOPE_ROLE_USER");
	}
	
	@Test
	void getListUserTest() {
		Optional<List<User>> listUser = Optional.of(List.of( UserUtils.getUser()));
		when(userRepository.findByRole("SCOPE_ROLE")).thenReturn(listUser);
		when(mapper.userTOUserDTO(listUser.get().get(0))).thenReturn(UserUtils.getUserMockDTO());
		when(mapper.roleDTO(listUser.get().get(0).getRole())).thenReturn( UserUtils.roleDTOMock());
		List<UserDTO> listUserDTO = this.userService.getListUser("SCOPE_ROLE"); 
		assertThat(listUserDTO.size()).isEqualTo(1);
	}
	
	
	@Test
	void createdUserTest() {
		when(roleRepository.findById(2L)).thenReturn( Optional.of(UserUtils.getRole()));
		when(mapper.userRegisterTOUser(UserUtils.getUserDTO())).thenReturn( UserUtils.getUser());
		String resp = this.userService.createdUser(UserUtils.getUserDTO());
		assertThat("User created").isEqualTo(resp);
	}
	
	@Test
	void deleteUser() {
		Optional<User> user = Optional.of(UserUtils.getUser());
		when(this.userRepository.findById(1L)).thenReturn(user);
		String resp = this.userService.deleteUser(1L);
		assertThat("User deteted").isEqualTo(resp);
	}
}
