package com.skipthedishes.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Customer extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String email;
	
	@NotNull
	private String name;
	
	@NotNull
	private String address;
	
	@CreatedDate
	private LocalDate creation;
	
	private String password;
	
	/** GETTERS & SETTERS **/
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getCreation() {
		return creation;
	}

	public void setCreation(LocalDate creation) {
		this.creation = creation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
