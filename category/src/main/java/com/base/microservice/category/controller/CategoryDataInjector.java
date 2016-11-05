package com.base.microservice.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.base.microservice.category.hibernate.domain.Category;
import com.base.microservice.category.service.CategoryService;

@Controller
public class CategoryDataInjector implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;
	
	@Override
	public void run(String... args) throws Exception {
		Category ticket = new Category("Tiket");
		
		Category ticket_01 = new Category("Kereta Api");
		
		Category ticket_02 = new Category("Pesawat");
	}

}
