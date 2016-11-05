package com.base.microservice.security.hibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "authorization_group_menu_items")
@Data
public class AuthorizationGroupMenuItem implements Comparable<AuthorizationGroupMenuItem> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	int id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authorization_group_id")
	@JsonIgnore
	private AuthorizationGroup authorizationGroup;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_item_id")
	private MenuItem menuItem;

	@Column(name = "item_sequence", length = 4)
	private int itemSequence;

	@Override
	public int compareTo(AuthorizationGroupMenuItem o) {
		return this.getItemSequence() - o.getItemSequence();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorizationGroupMenuItem other = (AuthorizationGroupMenuItem) obj;
		if (menuItem == null) {
			if (other.menuItem != null)
				return false;
		} else if (!menuItem.equals(other.menuItem))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuItem == null) ? 0 : menuItem.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "AuthorizationGroupMenuItems [id=" + id + "]";
	}

}
