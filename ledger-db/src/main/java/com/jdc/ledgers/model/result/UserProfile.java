package com.jdc.ledgers.model.result;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class UserProfile {

	public UserProfile() {
	}

	private int id;

	private String name;

	private String email;

	private Role role;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;

	public enum Role {
		Member, Admin
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}