package com.base.microservice.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.microservice.security.hibernate.domain.AuthorizationGroup;
import com.base.microservice.security.service.MobilePortalSecurityService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/secure/")
public class MenuItemRestController {

	@Autowired
	private MobilePortalSecurityService mobilePortalSecurityService;

	@PostMapping("/authorize")
	@ApiOperation(nickname = "Authorize user", value = "Authorize user", tags = "Security", response = AuthorizationGroup.class, notes = "Authorize user based on username."
			+ "This is very simple implementation, which needs role to get list of authorized menu items for particular role."
			+ "Can return null if role is not valid (i.e: wrong role name)."
			+ "\n\n Valid role for demo purpose is 'admin' or 'user'."
			+ "\n\n Valid values for menu item's type are : SECTION  WORDPRESS  YOUTUBE  RSS  FACEBOOK  INSTAGRAM  "
			+ "TWITTER  WEBVIEW  TUMBLR  RADIO  VIDEO  SOUNDCLOUD  MAPS  INTENT. <br/>Note than itemSequence should be used to "
			+ "maintain order in which items added to menu.<br/>"
			+ "\n\n You need to provide basic http authentication on your requests' header for this endpoint.<br/>"
			+ "\n\n Username and password must be the same with username/password combination during authentication"
			+ " (username/password combination on login screen).")
	private AuthorizationGroup authorize(@ApiParam(value = "Valid role") @RequestBody String role) {
		return mobilePortalSecurityService.authorize(role);
	}

}
