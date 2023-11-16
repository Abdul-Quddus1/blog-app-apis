package com.codewithabdul.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithabdul.blog.payloads.ApiResponse;
import com.codewithabdul.blog.payloads.UserDto;
import com.codewithabdul.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	//create new user
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		
		UserDto creaUserDto=this.userService .createUser(userDto);
		System.out.println("this is"+creaUserDto);
		
		
		return 	new ResponseEntity<>(creaUserDto,HttpStatus.CREATED);
		
	}
	
	//update user
	
	@PutMapping("/{userid}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userid") Integer uid){
		
		UserDto updateUserDto=this.userService.updateUser(userDto, uid);
		
		return ResponseEntity.ok(updateUserDto);
		
	}
	
	//delete user
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable ("userid") Integer uid){
		 this.userService.deleteUser(uid);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("User Succesfullyu deleted",true),HttpStatus.OK);
		
		
	}
	
	//Get All users Records
	
	
	  @GetMapping("/") public ResponseEntity<List<UserDto>>getAllUsers(){
	  
	  return ResponseEntity.ok(this.userService.getAllUsers());
	  
	  
	  }
	 
		/*
		 * @GetMapping("/") public String home() { return "index"; }
		 */
	
	//Get Single user Record
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto>getUserById(@PathVariable("userid")Integer uid){
		return ResponseEntity.ok(this.userService.getUserById(uid));
		
	}
		
		
		
	}


