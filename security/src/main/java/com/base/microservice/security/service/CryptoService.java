package com.base.microservice.security.service;

public interface CryptoService {

	String encrypt(String password);
	
	boolean matches(String rawPassword, String encodedPassword);

}
