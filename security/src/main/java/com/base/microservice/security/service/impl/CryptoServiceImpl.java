package com.base.microservice.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.base.microservice.security.service.CryptoService;
	
@Service
public class CryptoServiceImpl implements CryptoService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String encrypt(String original) {
		return passwordEncoder.encode(original);
	}

	@Override
	public boolean matches(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

}
