package com.skipthedishes.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Product extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity=Store.class, cascade=CascadeType.PERSIST)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
	@JsonIdentityReference(alwaysAsId=true)
	private Store store;

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NotNull
	private Double price;
	
	/** GETTERS & SETTERS **/

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}






}
