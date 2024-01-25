package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	String userName;
	
	String email;
	
	String phoneNo;
	
	String password;
	
	@Enumerated(EnumType.STRING)
	Role role;
	LocalDate regDate;
	
	@JsonIgnore
	@OneToMany(mappedBy="provider", 
			cascade = CascadeType.ALL, orphanRemoval=true)
	List<Product> products = new ArrayList<>();

	public User(String userName, String email, String phoneNo, String password, Role role, LocalDate regDate,
			List<Product> products) {
		super();
		this.userName = userName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.role = role;
		this.regDate = regDate;
		this.products = products;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", role=" + role + ", regDate=" + regDate + ", products=" + products + "]";
	}

	public User() {
		super();
	}
	
}
