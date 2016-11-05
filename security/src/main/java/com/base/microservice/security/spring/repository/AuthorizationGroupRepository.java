package com.base.microservice.security.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.microservice.security.hibernate.domain.AuthorizationGroup;

public interface AuthorizationGroupRepository extends CrudRepository<AuthorizationGroup, Integer> {

	List<AuthorizationGroup> findByGroupNameIgnoreCase(String groupName);
	
}
