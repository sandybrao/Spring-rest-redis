package com.rest.crud.service;

import java.util.List;
import java.util.Optional;

import com.rest.crud.entity.AppUser;

public interface UserService {

	public AppUser save(AppUser appUser);
	public List<AppUser> getAllUser();
	public Optional<AppUser> getUserById(String id);
	public AppUser updateUser(AppUser appUser);
	public void deleteUser(String id);
}
