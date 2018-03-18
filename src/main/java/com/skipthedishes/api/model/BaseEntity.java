package com.skipthedishes.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@MappedSuperclass
abstract class BaseEntity implements JSONifiable {
	@Id
	@Column(name="customer_id", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	/**
	 * Returns a String with the JSON representation of the object
	 * @return
	 * @throws JsonProcessingException
	 */
	public String asJsonString() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonifiedObject = ow.writeValueAsString(this);
		return jsonifiedObject;
	}

	/**GETTERS & SETTERS **/
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
}
