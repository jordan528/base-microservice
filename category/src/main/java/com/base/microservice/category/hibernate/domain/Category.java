package com.base.microservice.category.hibernate.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true, nullable = false, length = 255)
	@NonNull
	private String name;

	@Column(name = "date_start")
	private Date dateStart;

	@Column(name = "date_end")
	private Date dateEnd;

	@ManyToOne
	@JoinColumn(name = "parent_category_id")
	private Category parentCategory;

	@OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
	private Set<Category> childCategories;

	public Category() {
		LocalDateTime ldt = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
		Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
		this.dateStart = Date.from(instant);

		LocalDateTime ldt2 = LocalDateTime.of(2099, 12, 31, 23, 59);
		Instant instant2 = ldt2.atZone(ZoneId.systemDefault()).toInstant();
		this.dateEnd = Date.from(instant2);
	}

	public Category(String name) {
		this();
		setName(name);
	}

}
