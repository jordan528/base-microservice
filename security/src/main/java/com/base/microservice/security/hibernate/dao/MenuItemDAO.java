package com.base.microservice.security.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.microservice.security.hibernate.domain.MenuItem;
import com.base.microservice.security.spring.repository.MenuItemRepository;

@Repository
public class MenuItemDAO {

	@Autowired
	private MenuItemRepository menuItemRepository;

	public Iterable<MenuItem> findAll() {
		return menuItemRepository.findAll();
	}

	public Iterable<MenuItem> findAll(Iterable<Integer> ids) {
		return menuItemRepository.findAll(ids);
	}

	public MenuItem findOne(int id) {
		return menuItemRepository.findOne(id);
	}

	public Iterable<MenuItem> save(Iterable<MenuItem> menuItems) {
		return menuItemRepository.save(menuItems);
	}
	
	public MenuItem save(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

}
