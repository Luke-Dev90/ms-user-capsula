package com.chale.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.chale.user.dto.RoleDTO;
import com.chale.user.dto.UserDTO;
import com.chale.user.dto.UserRegisterDTO;
import com.chale.user.mapper.UserMapper;
import com.chale.user.model.Role;
import com.chale.user.model.User;
import com.chale.user.repository.RoleRepository;
import com.chale.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public UserDTO getUserByUsername(String username) {
		Optional<User> userOptional = this.userRepository.findByUsername(username);
		if (!userOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
		}
		
		UserDTO userDto = this.mapper.userTOUserDTO(userOptional.get());
		RoleDTO role = this.mapper.roleDTO(userOptional.get().getRole());
		userDto.setRole(role);
		return userDto;
	}

	public List<UserDTO> getListUser(String role) {
		Optional<List<User>> list = this.userRepository.findByRole(role);
		List<UserDTO> listUserDTO = new ArrayList<>();
		
		if (list.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users find by role not found");
		}
		
		list.get().forEach( u -> {
			UserDTO dto = this.mapper.userTOUserDTO(u);
			dto.setRole(this.mapper.roleDTO(u.getRole()));
			listUserDTO.add(dto);
		});
		
		return listUserDTO;
	}

	public String createdUser(UserRegisterDTO userRegisterDTO) {
		
		if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getPassword2())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password not equals");
		}

		// TODO: ENCODER PASSWORD
		// userRegisterDTO.setPasssword( encoder( userRegisterDTO.getPasssword() ));

		User user = this.mapper.userRegisterTOUser(userRegisterDTO);
		user.setActived(true);
		Role role = this.roleRepository.findById(2L).get();

		user.setRole(role);
		this.userRepository.save(user);
		return "User created";
	}

	@Transactional
	public String deleteUser(Long id) {
		Optional<User> user = this.userRepository.findById(id);
		if (!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User not found");
		}
		User userEntity = user.get();
		userEntity.setActived(false);
		this.userRepository.save(userEntity);
		return "User deteted";
	}

}
