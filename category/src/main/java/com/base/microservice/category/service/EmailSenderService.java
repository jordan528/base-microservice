package com.base.microservice.category.service;

import org.springframework.http.ResponseEntity;

import com.base.microservice.category.model.EmailSingleRecipient;

public interface EmailSenderService {
	
	public ResponseEntity<String> sendToOne(EmailSingleRecipient emailSingleRecipient);

}
