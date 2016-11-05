package com.base.microservice.security.hibernate.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.base.microservice.security.constants.MenuItemType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "menu_items")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MenuItem {

	@JsonIgnore
	@Id
	@Column(name = "menu_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(length = 50, nullable = false)
	@NonNull
	private String title;

	@OneToMany(mappedBy = "menuItem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<AuthorizationGroupMenuItem> authorizationGroupMenuItem;

	@Column(name = "icon_path", length = 500)
	private String iconPath;

	/**
	 * @see MenuItemType
	 */
	@Column(length = 25, nullable = false)
	@NonNull
	private String type;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menuItem", cascade = CascadeType.ALL)
	private List<MenuItemParameter> parameters;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", title=" + title + "]";
	}
}
