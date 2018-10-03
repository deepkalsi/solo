package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="SOLO_ROLE")
@NamedQueries({
	@NamedQuery(name="role.RoleType", query ="Select r FROM Role r WHERE r.name =:name")
	
})
public class Role {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	
	
	@Column(name="role_name")
	private String name;
	
	public Role(String name, List<User> users) {
		super();
		this.name = name;
		this.users = users;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}

	@ManyToMany(mappedBy="roles")
	private List<User> users;
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	
	

}
