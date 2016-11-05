package com.base.microservice.email.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
abstract class Email {

	private List<EmailAttachment> attachments;

	@NonNull
	private String body;

	@NonNull
	private String subject;

	public boolean hasAttachments() {
		return attachments != null && !attachments.isEmpty();
	}

}
