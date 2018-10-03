package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue(value="Admin")
public class AdminUser extends User{
	/**
	 * 
	 */
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(columnDefinition= "Number(1)")
	private boolean adminAccess;

	

	@Override
	public String toString() {
		return "AdminUser [adminAccess=" + adminAccess + "]";
	}

	public boolean isAdminAccess() {
		return adminAccess;
	}

	public void setAdminAccess(boolean adminAccess) {
		this.adminAccess = adminAccess;
	}

	/**
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param roles
	 * @param adminAccess
	 */
	public AdminUser(String username, String password, String firstname, String lastname, List<Role> roles) {
		super(username, password, firstname, lastname, roles);
		this.adminAccess =true;
	}

}
