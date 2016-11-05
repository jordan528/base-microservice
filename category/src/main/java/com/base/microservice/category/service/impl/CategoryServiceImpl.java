package com.base.microservice.category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.microservice.category.hibernate.domain.Category;
import com.base.microservice.category.service.CategoryService;
import com.base.microservice.category.spring.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

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
