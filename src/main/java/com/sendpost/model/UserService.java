package com.sendpost.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	UserRepository userRepository;

	PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	public void saveUser(UserModel userModel) {
		String enCyrpString = this.passwordEncoder.encode(userModel.getPassword());
		userModel.setPassword(enCyrpString);
		userRepository.save(userModel);

	}

}
