package com.base.microservice.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticRestController {

	@RequestMapping(value = { "/", " * " }, produces = "text/html")
	public String defaultUrl() {
		return "Project Product from <a href=\"https://github.com/timpamungkas/base-microservice/tree/master/product\">github</a>";
	}

}
