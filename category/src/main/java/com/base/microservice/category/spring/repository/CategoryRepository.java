package com.base.microservice.category.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.base.microservice.category.hibernate.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

	List<Category> findByNameIgnoreCase(String name);

}
