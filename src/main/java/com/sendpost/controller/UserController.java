package com.sendpost.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sendpost.error.ApiError;
import com.sendpost.model.UserModel;
import com.sendpost.model.UserService;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class UserController {

	@Resource
	UserService userService;

	@CrossOrigin
	@PostMapping("/api/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserModel user) {
		userService.saveUser(user);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private ApiError handleValidationException(MethodArgumentNotValidException exception) {
		Map<String, String> validationErrorMap = new HashMap<>();
		ApiError error = new ApiError(400, "Validation Error", "/api/users");
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {

			validationErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrorMap);
		return error;

	}

}
