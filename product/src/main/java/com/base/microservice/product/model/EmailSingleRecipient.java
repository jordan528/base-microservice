package com.base.microservice.product.model;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmailSingleRecipient extends Email {

	private String bcc;
	
	private String cc;
	
	@NotNull
	@NonNull
	private String to;

}
