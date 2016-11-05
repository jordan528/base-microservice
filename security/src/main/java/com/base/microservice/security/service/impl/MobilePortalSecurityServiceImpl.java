package com.base.microservice.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.microservice.security.hibernate.dao.AuthorizationGroupDAO;
import com.base.microservice.security.hibernate.dao.UserAccountDAO;
import com.base.microservice.security.hibernate.domain.AuthorizationGroup;
import com.base.microservice.security.hibernate.domain.UserAccount;
import com.base.microservice.security.service.CryptoService;
import com.base.microservice.security.service.MobilePortalSecurityService;

@Service
public class MobilePortalSecurityServiceImpl implements MobilePortalSecurityService {

	@Autowired
	private AuthorizationGroupDAO authorizationGroupDAO;

	@Autowired
	private UserAccountDAO userAccountDAO;

	@Autowired
	private CryptoService cryptoServiceImpl;

	@Override
	public UserAccount authenticate(String username, String password) {
		// return userDAO.findOneByUsernameIgnoreCaseAndPassword(username,
		// password) == null ? "INVALID" : "VALID";

		UserAccount user = userAccountDAO.findOneByUsernameIgnoreCase(username);

		if (user != null && cryptoServiceImpl.matches(password, user.getPassword())) {
			return user;
		}

		return null;
	}

	@Override
	public AuthorizationGroup authorize(String role) {
		return authorizationGroupDAO.findOneByGroupNameIgnoreCase(role);
	}

}
