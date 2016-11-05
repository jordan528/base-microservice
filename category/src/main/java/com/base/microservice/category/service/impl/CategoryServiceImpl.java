package com.base.microservice.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.base.microservice.category.hibernate.domain.Category;
import com.base.microservice.category.spring.repository.CategoryRepository;

public class CategoryServiceImpl {

	@Autowired
	private CategoryRepository categoryRepository;

	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	public List<Category> findByNameIgnoreCase(String name) {
		return categoryRepository.findByNameIgnoreCase(name);
	}

	public Category findOne(int id) {
		return categoryRepository.findOne(id);
	}

	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	public Iterable<Category> save(Iterable<Category> categories) {
		return categoryRepository.save(categories);
	}

}
