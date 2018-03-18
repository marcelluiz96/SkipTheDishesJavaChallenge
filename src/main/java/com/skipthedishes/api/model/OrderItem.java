package com.skipthedishes.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class OrderItem extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinTable(name="order_items")
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,
		property="id")
	@JsonIdentityReference(alwaysAsId=true)
	private ProductOrder order;
	
	@ManyToOne(targetEntity=Product.class)
	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,
		property="id")
	@JsonIdentityReference(alwaysAsId=true)
	private Product product;
	
	private Double price;
	
	private Long quantity;
	
	private Double total;
	
	/** GETTERS & SETTERS **/

	public ProductOrder getOrder() {
		return order;
	}

	public void setOrder(ProductOrder order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	
	
	

}
