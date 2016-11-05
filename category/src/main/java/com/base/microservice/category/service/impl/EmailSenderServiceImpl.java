package com.base.microservice.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.base.microservice.category.model.EmailSingleRecipient;
import com.base.microservice.category.service.EmailSenderService;

/**
 * Configure this as a ribbon client that calls service on node email. Note that
 * instead of calling physical address of "email" service, we use lookup from
 * eureka server. Lookup was configured on EmailRibbonConfig.class
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<String> sendToOne(EmailSingleRecipient emailSingleRecipient) {
		// not call http://domain.com/path_to_api, but instead we use
		// http://email, which is alias from eureka.
		// Note that because I use zuul, these two URL will do:
		// 1. http://email/xxx > direct hit to Eureka alias
		// 2. http://zuul/email/xxx > via zuul proxy
		ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://email/api/email/sender/sendToOne",
				emailSingleRecipient, String.class);

		return responseEntity;
	}

}
