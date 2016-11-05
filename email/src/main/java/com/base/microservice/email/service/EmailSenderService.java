package com.base.microservice.email.service;

import java.util.Set;

import javax.mail.MessagingException;

import com.base.microservice.email.model.EmailAttachment;

public interface EmailSenderService {

	/**
	 * Send email to many recipients for each to, cc, and bcc.
	 * 
	 * @param to
	 *            list of recipients
	 * @param cc
	 *            list of recipients
	 * @param bcc
	 *            list of recipients
	 * @param subject
	 *            email subject
	 * @param body
	 *            email body
	 * @param isHtmlContent
	 *            if true then email body will be treated as html
	 * @param attachments
	 *            attachments
	 * @throws MessagingException
	 */
	public String sendToMany(Set<String> to, Set<String> cc, Set<String> bcc, String subject, String body,
			boolean isHtmlContent, EmailAttachment... attachments) throws MessagingException;

	/**
	 * Send email to one recipient for each to, cc, and bcc.
	 * 
	 * @param to
	 *            single recipient
	 * @param cc
	 *            single recipient
	 * @param bcc
	 *            single recipient
	 * @param subject
	 *            email subject
	 * @param body
	 *            email body
	 * @param isHtmlContent
	 *            if true then email body will be treated as html
	 * @param attachments
	 *            attachments
	 * @throws MessagingException
	 */
	public String sendToOne(String to, String cc, String bcc, String subject, String body, boolean isHtmlContent,
			EmailAttachment... attachments) throws MessagingException;
}
