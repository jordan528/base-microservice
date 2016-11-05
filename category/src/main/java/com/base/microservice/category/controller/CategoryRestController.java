package com.base.microservice.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.microservice.category.model.EmailSingleRecipient;
import com.base.microservice.category.service.EmailSenderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

	@Autowired
	private EmailSenderService emailSenderService;

	@ApiOperation(tags = "Category", value = "Save category & notify admin", nickname = "Save category & notify admin", notes = "Save category into 'categories' table, "
			+ "then call email service (on different service node) to send email about saved category to administrator.")
	@PostMapping(value = "/save", produces = "text/html")
	public String saveAndNotify() {
		EmailSingleRecipient emailSingleRecipient = new EmailSingleRecipient("someone.email@gmail.com");
		emailSingleRecipient.setBody("A new category published just now.");
		emailSingleRecipient.setSubject("New category published");

		ResponseEntity<String> x = emailSenderService.sendToOne(emailSingleRecipient);

		return "Notification sent: " + x.getBody();
	}

}
