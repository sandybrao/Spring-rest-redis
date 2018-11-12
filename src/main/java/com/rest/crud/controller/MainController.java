package com.rest.crud.controller;

import java.util.List;
import java.util.Optional;

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

import com.rest.crud.entity.AppUser;
import com.rest.crud.service.UserService;

@RestController
@RequestMapping("/rest")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(){
		return "Spring Boot Data JPA + Redis CRUD Restfull Webservices.";
	}
	
	@PostMapping("/save")
	public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser){
	 	AppUser user = userService.save(appUser);
		return new ResponseEntity<AppUser>(user , HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<AppUser>> getUserById(@PathVariable("id")String id){
		Optional<AppUser> user = userService.getUserById(id);
		return new ResponseEntity<Optional<AppUser>>(user , HttpStatus.OK);
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<List<AppUser>> getAllUsers(){
		List<AppUser> userList = userService.getAllUser();
		return new ResponseEntity<List<AppUser>>(userList , HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<AppUser> updateUser(@RequestBody AppUser user) {
		AppUser updatedUser = userService.updateUser(user);
		return new ResponseEntity<AppUser>(updatedUser, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
