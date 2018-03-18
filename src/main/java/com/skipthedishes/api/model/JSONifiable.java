package com.skipthedishes.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JSONifiable extends Serializable {
	abstract String asJsonString()  throws JsonProcessingException;
}
