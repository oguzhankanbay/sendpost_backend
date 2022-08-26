package com.sendpost.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sendpost.model.UserModel;
import com.sendpost.model.UserService;
import javax.annotation.Resource;

@RestController
public class UserController {

	@Resource
	UserService userService;
	@CrossOrigin
	@PostMapping("/api/users")
	public ResponseEntity<Object> createUser(@RequestBody UserModel user) {
		userService.saveUser(user);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
