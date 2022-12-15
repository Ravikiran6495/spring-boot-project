package com.codewithravikiran.blog.services;

 import java.util.List;

import com.codewithravikiran.blog.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllusers();
	
	void deleteUser(Integer userId);

}
