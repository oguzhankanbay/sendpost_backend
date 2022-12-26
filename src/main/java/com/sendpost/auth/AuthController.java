package com.sendpost.auth;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sendpost.model.UserModel;
import com.sendpost.shared.CurrentUser;

@RestController
public class AuthController {

	@PostMapping("/api/auth")
	ResponseEntity<?> handleAuth(@CurrentUser UserModel userModel) {
		return ResponseEntity.ok(userModel);
		
	}
	

}