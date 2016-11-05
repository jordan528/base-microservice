package com.base.microservice.category.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticRestController {

	@RequestMapping(value = { "/", " * " }, produces = "text/html")
	public String defaultUrl() {
		return "Project Category from <a href=\"https://github.com/timpamungkas/base-microservice/tree/master/category\">github</a>";
	}

}
