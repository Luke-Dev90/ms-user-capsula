package com.chale.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chale.user.dto.UserDTO;
import com.chale.user.dto.UserRegisterDTO;
import com.chale.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }
    @GetMapping("/search/username")
    public ResponseEntity<UserDTO> getByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }
    
    @GetMapping("/search/users")
    public ResponseEntity<List<UserDTO>> getUsersByRole(@RequestParam("role") String role){
    	return ResponseEntity.ok(this.userService.getListUser(role));
    }
    
    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody UserRegisterDTO userRegisterDTO){
    	String resp = this.userService.createdUser(userRegisterDTO);
    	return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
    	String resp = this.userService.deleteUser(id);
    	return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}