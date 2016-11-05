package com.base.microservice.security.hibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.microservice.security.hibernate.domain.AuthorizationGroup;
import com.base.microservice.security.spring.repository.AuthorizationGroupRepository;

@Repository
public class AuthorizationGroupDAO {

	@Autowired
	private AuthorizationGroupRepository authorizationGroupRepository;

	public Iterable<AuthorizationGroup> findAll() {
		return authorizationGroupRepository.findAll();
	}

	public AuthorizationGroup findOne(int id) {
		return authorizationGroupRepository.findOne(id);
	}
	
	public AuthorizationGroup findOneByGroupNameIgnoreCase(String groupName) {
		List<AuthorizationGroup> authorizationGroups = authorizationGroupRepository.findByGroupNameIgnoreCase(groupName);

		return authorizationGroups.isEmpty() ? null : authorizationGroups.get(0);
	}

	public AuthorizationGroup save(AuthorizationGroup authorizationGroup) {
		return authorizationGroupRepository.save(authorizationGroup);
	}

}
