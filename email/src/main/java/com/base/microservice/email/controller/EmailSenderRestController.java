package com.base.microservice.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.microservice.email.model.EmailAttachment;
import com.base.microservice.email.model.EmailManyRecipients;
import com.base.microservice.email.model.EmailSingleRecipient;
import com.base.microservice.email.service.EmailSenderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/email/sender")
public class EmailSenderRestController {

	@Autowired
	private EmailSenderService emailSenderService;

	@ApiOperation(tags = "Email", nickname = "Send email to many recipients at once.", value = "Send email to many recipients at once.", notes = "Send email to many recipients at once.")
	@PostMapping("/sendToMany")
	public @ApiResponses(value = { @ApiResponse(code = 200, message = "Mail sent", response = String.class),
			@ApiResponse(code = 500, message = "Mail not sent: + error message", response = String.class) }) ResponseEntity<?> sendToMany(
					@ApiParam(value = "Email to many recipients as json request", name = "Email request", required = true) @RequestBody EmailManyRecipients emailManyRecipients) {
		try {
			emailSenderService.sendToMany(emailManyRecipients.getToList(), emailManyRecipients.getCcList(),
					emailManyRecipients.getBccList(), emailManyRecipients.getSubject(), emailManyRecipients.getBody(),
					true, emailManyRecipients.getAttachments().stream().toArray(EmailAttachment[]::new));
		} catch (MessagingException e) {
			return new ResponseEntity<String>("Mail not sent: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>("Mail sent", HttpStatus.OK);
	}

	@ApiOperation(tags = "Email", nickname = "Send email to one recipient / cc / bcc.", value = "Send email to one recipient / cc / bcc.", notes = "Send email to one recipient / cc / bcc.")
	@PostMapping("/sendToOne")
	public @ApiResponses(value = { @ApiResponse(code = 200, message = "Mail sent", response = String.class),
			@ApiResponse(code = 500, message = "Mail not sent: + error message", response = String.class) }) ResponseEntity<String> sendToOne(
					@RequestBody @ApiParam(value = "Email to one recipient / cc / bcc as json request", name = "Email request", required = true) EmailSingleRecipient emailSingleRecipient) {
		try {
			EmailAttachment[] attachmentArrays = null;
			if (emailSingleRecipient.hasAttachments()) {
				attachmentArrays = emailSingleRecipient.getAttachments().stream().toArray(EmailAttachment[]::new);
			} else {
				attachmentArrays = new EmailAttachment[0];
			}
			emailSenderService.sendToOne(emailSingleRecipient.getTo(), emailSingleRecipient.getCc(),
					emailSingleRecipient.getBcc(), emailSingleRecipient.getSubject(), emailSingleRecipient.getBody(),
					true, attachmentArrays);
		} catch (MessagingException e) {
			return new ResponseEntity<String>("Mail not sent: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>("Mail sent", HttpStatus.OK);
	}

}
