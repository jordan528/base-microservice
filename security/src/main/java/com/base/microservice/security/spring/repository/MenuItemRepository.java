package com.base.microservice.security.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.base.microservice.security.hibernate.domain.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {

}
