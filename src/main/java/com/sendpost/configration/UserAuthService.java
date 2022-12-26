package com.sendpost.configration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sendpost.model.UserModel;
import com.sendpost.model.UserRepository;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
	UserRepository userRepository;	
	
	
	@Override
	public UserModel loadUserByUsername(String username){
        UserModel userModel= userRepository.findByUsername(username);
        if (userModel==null) {
        	throw new UsernameNotFoundException("User is not found");
			
		}
		return userModel;
	}
	

}
