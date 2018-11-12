package com.rest.crud.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.crud.entity.AppUser;

@Repository
public interface UserRepository extends CrudRepository<AppUser, String> {

}
