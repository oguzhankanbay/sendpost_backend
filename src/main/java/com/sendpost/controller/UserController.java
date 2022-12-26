package com.sendpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sendpost.model.UserModel;
import com.sendpost.model.UserService;



import javax.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin
	@PostMapping("/api/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserModel user) {
		userService.saveUser(user);
		return new ResponseEntity<>(HttpStatus.OK);

	}



}
