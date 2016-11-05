package com.base.microservice.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.base.microservice.product.client.rest.EmailRestClient;
import com.base.microservice.product.model.EmailSingleRecipient;
import com.base.microservice.product.service.EmailSenderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private EmailRestClient emailRestClient;

	@Override
	@HystrixCommand(fallbackMethod = "emailFallback")
	public String sendEmail(EmailSingleRecipient emailSingleRecipient) {
		// using feign client
		// no endpoint URL required. Feign client will register itself to "email" service
		// found in eureka service.
		// See EmailRestClient @FeignClient annotation
		ResponseEntity<String> x = emailRestClient.sendToOne(emailSingleRecipient);

		return x.getBody();
	}
	
	public String emailFallback(EmailSingleRecipient emailSingleRecipient) {
		return "Email can't send due to some errors";
	}

}
