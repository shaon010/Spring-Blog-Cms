package org.mpb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<Users> users;

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}
}
