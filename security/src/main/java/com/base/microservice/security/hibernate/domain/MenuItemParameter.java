package com.base.microservice.security.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "menu_item_parameters")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class MenuItemParameter {

	@JsonIgnore
	@Id
	@Column(name = "menu_item_param_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 255, nullable = false)
	@NonNull
	private String value;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_item_id", nullable = false)
	@NonNull
	private MenuItem menuItem;

	@JsonIgnore
	public MenuItem getMenuItem() {
		return menuItem;
	}

	@Override
	public String toString() {
		return "MenuItemParameter [id=" + id + ", value=" + value + "]";
	}

}
