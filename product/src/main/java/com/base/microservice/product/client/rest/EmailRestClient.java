package com.base.microservice.product.client.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.base.microservice.product.model.EmailSingleRecipient;

/*
 * Feign client name is same as eureka registered name.
 */
@FeignClient("email")
public interface EmailRestClient {

	/*
	 * The "value" is the same as path for REST api on "email" eureka client. In
	 * this example, this will be the same with project "email", on
	 * EmailSenderRestController.java.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/api/email/sender/sendToOne")
	public ResponseEntity<String> sendToOne(EmailSingleRecipient emailSingleRecipient);

}
