package com.base.microservice.product.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmailSingleRecipient extends Email {

	private String bcc;
	
	private String cc;
	@NonNull
	private String to;

}
