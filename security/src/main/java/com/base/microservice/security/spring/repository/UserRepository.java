package com.base.microservice.security.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.base.microservice.security.hibernate.domain.UserAccount;

public interface UserRepository extends CrudRepository<UserAccount, Integer> {

	UserAccount findOneByUsernameIgnoreCase(String username);

	UserAccount findOneByUsernameIgnoreCaseAndPassword(String username, String password);

}
