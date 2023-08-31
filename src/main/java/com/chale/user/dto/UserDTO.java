package com.chale.user.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String nombre;
    private String apellido;
    private String telefono;
    private String sexo;
    private String pais;
    private Date fechaAlta;
    private RoleDTO role;
    private boolean actived;
}
