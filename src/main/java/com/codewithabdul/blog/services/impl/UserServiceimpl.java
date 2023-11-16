package com.codewithabdul.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codewithabdul.blog.exceptions.*;

import com.codewithabdul.blog.entities.User;
//import com.codewithabdul.blog.exceptions.ResourceNotFoundException;
import com.codewithabdul.blog.payloads.UserDto;
import com.codewithabdul.blog.repositories.UserRepo;
import com.codewithabdul.blog.services.UserService;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@ Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, Integer userid) {

		User user = this.userRepo.findById(userid)
				.orElseThrow();
        
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
	

		User updateuser = this.userRepo.save(user);

		UserDto userDto1 = this.userToDto(updateuser);

		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userid) {
		
		User user =this.userRepo.findById(userid)
				.orElseThrow(()->new ResourceNotFoundException("User", "id",userid));
		
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
List<UserDto>	userDtos	=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userid) {
		
		User user=this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("user","id", userid));
		 
    this.userRepo.delete(user);
		
	}

	private User dtoToUser(UserDto userDto) {
		User user =this.modelMapper.map(userDto, User.class);

		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */
		return user;

	}

	public UserDto userToDto(User user) {
		UserDto userDto =this.modelMapper.map(user, UserDto.class);

		/*userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());*/
		return userDto;
	}

}
