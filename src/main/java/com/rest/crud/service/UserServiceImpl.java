package com.rest.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.crud.Repository.UserRepository;
import com.rest.crud.entity.AppUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public AppUser save(AppUser appUser) {
		return userRepository.save(appUser);
	}

	@Override
	public List<AppUser> getAllUser() {
		return (List<AppUser>) userRepository.findAll();
	}

	@Override
	public Optional<AppUser> getUserById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public AppUser updateUser(AppUser appUser) {
		return userRepository.save(appUser);
		
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

}
