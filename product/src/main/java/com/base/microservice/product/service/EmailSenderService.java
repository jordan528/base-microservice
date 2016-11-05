package com.base.microservice.product.service;

import com.base.microservice.product.model.EmailSingleRecipient;

public interface EmailSenderService {

	String sendEmail(EmailSingleRecipient emailSingleRecipient);
}
