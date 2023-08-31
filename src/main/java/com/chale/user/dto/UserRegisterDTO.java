package com.chale.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
	private String username;
	private String password;
	private String password2;
	private String nombre;
	private String apellido;
	private String sexo;
	private String pais;
}
