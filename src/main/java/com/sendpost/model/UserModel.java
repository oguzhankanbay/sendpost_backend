package com.sendpost.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Size(min = 4,max =224)
	@NonNull
	private String userName;
	
	
	@Size(min = 4,max =224)
	@NonNull
	private String displayName;
	
	
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}")
	@NonNull
	private String password;
	

}
