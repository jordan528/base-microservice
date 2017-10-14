package com.base.microservice.email.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.base.microservice.email.model.EmailAttachment;
import com.base.microservice.email.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	public String me;

	@Override
	public String sendToMany(Set<String> to, Set<String> cc, Set<String> bcc, String subject, String body,
			boolean isHtmlContent, EmailAttachment... attachments) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

		if (to != null && !to.isEmpty()) {
			messageHelper.setTo(to.stream().toArray(String[]::new));
		}

		if (cc != null && !cc.isEmpty()) {
			messageHelper.setCc(cc.stream().toArray(String[]::new));
		}

		if (bcc != null && !bcc.isEmpty()) {
			messageHelper.setBcc(bcc.stream().toArray(String[]::new));
		}

		messageHelper.setSubject(subject);
		messageHelper.setText(body, isHtmlContent);

		for (EmailAttachment attachment : attachments) {
			messageHelper.addAttachment(attachment.getAttachmentFilename(), attachment.getInputStreamSource(),
					attachment.getContentType());
		}

		try {
			javaMailSender.send(message);
		} catch (Exception e) {
			throw new MessagingException(e.getMessage());
		}
		
		return "Mail sent";
	}

	@Override
	public String sendToOne(String to, String cc, String bcc, String subject, String body, boolean isHtmlContent,
			EmailAttachment... attachments) throws MessagingException {
		Set<String> toList = null;
		Set<String> ccList = null;
		Set<String> bccList = null;

		if (!StringUtils.isEmpty(to)) {
			toList = new LinkedHashSet<>(1);
			toList.add(to);
		}

		if (!StringUtils.isEmpty(cc)) {
			ccList = new LinkedHashSet<>(1);
			ccList.add(cc);
		}

		if (!StringUtils.isEmpty(bcc)) {
			bccList = new LinkedHashSet<>(1);
			bccList.add(bcc);
		}

		return sendToMany(toList, ccList, bccList, subject, body, isHtmlContent, attachments);
	}

}
