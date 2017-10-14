package com.base.microservice.product.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
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
