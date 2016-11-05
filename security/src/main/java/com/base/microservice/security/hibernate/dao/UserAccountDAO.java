package com.base.microservice.security.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.microservice.security.hibernate.domain.UserAccount;
import com.base.microservice.security.service.CryptoService;
import com.base.microservice.security.spring.repository.UserRepository;

@Repository
public class UserAccountDAO {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CryptoService cryptoService;

	public Iterable<UserAccount> findAll() {
		return userRepository.findAll();
	}

	public Iterable<UserAccount> findAll(Iterable<Integer> ids) {
		return userRepository.findAll(ids);
	}

	public UserAccount findOne(int id) {
		return userRepository.findOne(id);
	}

	public UserAccount findOneByUsernameIgnoreCase(String username) {
		return userRepository.findOneByUsernameIgnoreCase(username);
	}

	/**
	 * @param username
	 *            username
	 * @param password
	 *            un-encrypted password
	 * @return
	 */
	public UserAccount findOneByUsernameIgnoreCaseAndPassword(String username, String password) {
		return userRepository.findOneByUsernameIgnoreCaseAndPassword(username, cryptoService.encrypt(password));
	}

	public Iterable<UserAccount> save(Iterable<UserAccount> UserAccounts) {
		return userRepository.save(UserAccounts);
	}

	public UserAccount save(UserAccount UserAccount) {
		return userRepository.save(UserAccount);
	}

}
