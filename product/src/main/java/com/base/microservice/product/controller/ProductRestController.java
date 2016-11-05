package com.base.microservice.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.microservice.product.model.EmailSingleRecipient;
import com.base.microservice.product.service.EmailSenderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private EmailSenderService emailSenderService;

	@ApiOperation(tags = "Product", value = "Save product & notify admin", nickname = "Save product & notify admin", notes = "Save product into 'products' table, "
			+ "then call email service (on different service node) to send email about saved category to administrator.")
	@PostMapping(value = "/save", produces = "text/html")
	public String saveAndNotify() {
		EmailSingleRecipient emailSingleRecipient = new EmailSingleRecipient("someone.email@gmail.com");
		emailSingleRecipient.setBody("A new product published just now.");
		emailSingleRecipient.setSubject("New product published");

		String sentMessage = emailSenderService.sendEmail(emailSingleRecipient);

		return "Notification sent: " + sentMessage;
	}

}
