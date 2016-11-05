package com.base.microservice.product.hibernate.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "products")
public class Product {

	@Column(name = "date_end")
	private Date dateEnd;

	@Column(name = "date_start")
	private Date dateStart;

	@Column(length = 1000)
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 255)
	@NonNull
	private String name;

	@Column(nullable = false, length = 15)
	private double price;

}
