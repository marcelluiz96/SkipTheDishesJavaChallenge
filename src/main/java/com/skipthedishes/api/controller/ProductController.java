package com.skipthedishes.api.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.skipthedishes.api.model.Product;
import com.skipthedishes.api.repository.ProductRepository;
import com.skipthedishes.api.utils.ObjectParser;

@Component
@Path("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response getAllProducts() throws JsonProcessingException {

		List<Product> allProducts = productRepository.findAll();	

		try {
			return Response
					.ok(ObjectParser.jsonify(allProducts))
					.build();
		} catch (JsonProcessingException exception) {
			return Response.serverError().build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{productId}/stores")
	public Response getStoresByProductId(@PathParam("productId") Long productId) {

		Optional<Product> productOptional = productRepository.findById(productId);

		try {
			String jsonifiedProduct = productOptional
					.orElseThrow(RuntimeException::new)
					.asJsonString();
			
			return Response
					.ok(jsonifiedProduct)
					.build();
		} catch (JsonProcessingException | RuntimeException e) {
			return Response.serverError().build();
		}

	}

	//search
}
