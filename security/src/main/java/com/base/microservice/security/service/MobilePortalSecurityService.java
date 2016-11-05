package com.base.microservice.security.service;

import com.base.microservice.security.hibernate.domain.AuthorizationGroup;
import com.base.microservice.security.hibernate.domain.UserAccount;

public interface MobilePortalSecurityService {

	UserAccount authenticate(String username, String password);

	AuthorizationGroup authorize(String username);

}
