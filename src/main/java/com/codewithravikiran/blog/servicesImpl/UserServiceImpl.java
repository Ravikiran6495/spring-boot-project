package com.codewithravikiran.blog.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithravikiran.blog.entities.User;
import com.codewithravikiran.blog.exception.ResourceNotFoundException;
import com.codewithravikiran.blog.payloads.UserDto;
import com.codewithravikiran.blog.repository.userRepo;
import com.codewithravikiran.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private userRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = dtoTouser(userDto);
		// System.err.print("iser
		// is"+user.getName(),user.getPassword(),user.getAbout());
		User user1 = this.userRepo.save(user);
		return this.userToDto(user1);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());

		User updateduser = this.userRepo.save(user);
		return this.userToDto(updateduser);
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllusers() {

		List<User> users = this.userRepo.findAll();
		List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		this.userRepo.delete(user);
	}

	public User dtoTouser(UserDto userDto) {

		User user = modelMapper.map(userDto, User.class);
		/*
		 * User user =new User(); user.setId(userDto.getId());
		 * user.setName(userDto.getName()); user.setEmail(userDto.getEmail());
		 * user.setAbout(userDto.getAbout()); System.err.println(userDto.getName());
		 * System.out.println(userDto.getPassword());
		 * System.err.println(userDto.getAbout());
		 * user.setPassword(userDto.getPassword());
		 */

		return user;
	}

	public UserDto userToDto(User user) {

		UserDto useDto = modelMapper.map(user, UserDto.class);

		/*
		 * UserDto userDto = new UserDto(); userDto.setId(user.getId());
		 * userDto.setName(userDto.getName()); userDto.setEmail(user.getEmail());
		 * userDto.setAbout(userDto.getAbout());
		 * userDto.setPassword(userDto.getPassword());
		 */
		return useDto;
	}

}
