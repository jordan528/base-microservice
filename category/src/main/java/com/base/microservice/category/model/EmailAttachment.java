package com.base.microservice.category.model;

import org.springframework.core.io.InputStreamSource;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Mail attachment for sending mail
 * 
 * @author Timotius Pamungkas
 *
 */
@Data
@AllArgsConstructor
public class EmailAttachment implements Comparable<EmailAttachment> {

	private String attachmentFilename;
	private String contentType;
	private InputStreamSource inputStreamSource;

	@Override
	public int compareTo(EmailAttachment o) {
		return this.attachmentFilename.compareTo(o.attachmentFilename);
	}

}
