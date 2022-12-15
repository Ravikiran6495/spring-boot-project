package com.codewithravikiran.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "User name must be min of 4 cgarcater")
	private String name;
	
	@Email(message = "email adresss is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max =10, message = "password must be 3 character" )
	private String password;
	
	@NotEmpty
	private String about;
	

}
