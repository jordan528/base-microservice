package com.base.microservice.category.service;

import java.util.List;

import com.base.microservice.category.hibernate.domain.Category;

public interface CategoryService {

	Iterable<Category> findAll();

	List<Category> findByNameIgnoreCase(String name);

	Category findOne(int id);

	Category save(Category category);

	Iterable<Category> save(Iterable<Category> categories);

}
