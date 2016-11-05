package com.base.microservice.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.microservice.security.hibernate.domain.UserAccount;
import com.base.microservice.security.model.LoginBean;
import com.base.microservice.security.service.MobilePortalSecurityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/demo")
public class UserAccountRestController {

	@Autowired
	private MobilePortalSecurityService mobilePortalSecurityService;

	@PostMapping("/authenticate")
	@ApiOperation(nickname = "Authenticate user", value = "Authenticate user", tags = "Security", response = String.class, notes = "Authenticate user based on username and password."
			+ "This is for demo purpose only, so the only valid combination is : admin/password or user/password."
			+ "\n\n Possible return values are: null if username/password combination does not match, or JSON body "
			+ "containing user details (username & role). Role can be used for authorization process.<br/>"
			+ "\n\n To use this, use Content-Type=application/json on your request header, and build "
			+ "a JSON request body contains username and password.<br/>"
			+ "\n\n No http authentication required for this endpoint.")
	private UserAccount authenticate(
			@ApiParam(value = "Login credentials. Build a JSON body with 'username' and 'password' as key.") @RequestBody LoginBean loginBean) {
		return mobilePortalSecurityService.authenticate(loginBean.getUsername(), loginBean.getPassword());
	}

}
