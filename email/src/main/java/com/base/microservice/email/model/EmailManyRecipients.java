package com.base.microservice.email.model;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmailManyRecipients extends Email {

	private Set<String> bccList;

	private Set<String> ccList;
	@NonNull
	private Set<String> toList;

}
