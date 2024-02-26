package com.example.dmeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String username;
	String email;
	String password;
	String gemder;
	String role;
	String address;
	boolean isPremiun;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String username, String email, String password, String gemder, String role, String address,
			boolean isPremiun) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.gemder = gemder;
		this.role = role;
		this.address = address;
		this.isPremiun = isPremiun;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGemder() {
		return gemder;
	}

	public void setGemder(String gemder) {
		this.gemder = gemder;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPremiun() {
		return isPremiun;
	}

	public void setPremiun(boolean isPremiun) {
		this.isPremiun = isPremiun;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", gemder=" + gemder + ", role=" + role + ", address=" + address + ", isPremiun=" + isPremiun + "]";
	}

}
