package com.skipthedishes.api.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skipthedishes.api.controller.CousineController;
import com.skipthedishes.api.controller.CustomerController;
import com.skipthedishes.api.controller.ProductOrderController;
import com.skipthedishes.api.controller.ProductController;
import com.skipthedishes.api.controller.StoreController;



@Component
@Configuration
@ApplicationPath("api/v1")
public class JerseyConfiguration extends ResourceConfig{

	@PostConstruct
	public void setUp() {
		register(CousineController.class);
		register(CustomerController.class);
		register(ProductOrderController.class);
		register(ProductController.class);
		register(StoreController.class);
	}
	
	

}
