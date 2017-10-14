package com.base.microservice.email.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmailManyRecipients extends Email {

	private Set<String> bccList;

	private Set<String> ccList;
	@NotNull
	private Set<String> toList;

}
