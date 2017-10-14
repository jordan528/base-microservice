package com.base.microservice.security.hibernate.domain;

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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "authorization_groups", uniqueConstraints = { @UniqueConstraint(columnNames = "group_name") })
@Data
@NoArgsConstructor
public class AuthorizationGroup {

	public AuthorizationGroup(String groupName) {
		super();
		this.groupName = groupName;
	}

	@JsonIgnore
	@Id
	@Column(name = "authorization_group_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, unique = true, length = 100, name = "group_name")
	@NonNull
	private String groupName;

	@OneToMany(mappedBy = "authorizationGroup", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AuthorizationGroupMenuItem> authorizationGroupMenuItems;

	@Override
	public String toString() {
		return "AuthorizationGroup [id=" + id + ", groupName=" + groupName + "]";
	}

}
