package com.base.microservice.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticRestController {

	@RequestMapping(value = { "/", " * " }, produces = "text/html")
	public String defaultUrl() {
		return "Project Security from <a href=\"https://github.com/timpamungkas/base-microservice/tree/master/security\">github</a>";
	}

}
