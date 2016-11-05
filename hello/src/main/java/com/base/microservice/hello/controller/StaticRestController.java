package com.base.microservice.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class StaticRestController {

	@ApiOperation(nickname = "Hello world", tags = "Hello world", value = "Hello world", notes = "Project hello world, can also be used as template. Contains only one default mapping that shows some string")
	@RequestMapping(value = { "/", " * " }, produces = "text/html")
	public String defaultUrl() {
		return "Project Hello from <a href=\"https://github.com/timpamungkas/base-microservice/tree/master/hello\">github</a>";
	}

}
