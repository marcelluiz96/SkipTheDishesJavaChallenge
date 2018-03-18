package com.skipthedishes.api.controller;

import java.util.List;

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
import com.skipthedishes.api.model.Store;
import com.skipthedishes.api.repository.ProductRepository;
import com.skipthedishes.api.repository.StoreRepository;
import com.skipthedishes.api.utils.ObjectParser;

@Component
@Path("/store")
public class StoreController {
	
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response getAllStores() throws JsonProcessingException {

		List<Store> allStores = storeRepository.findAll();	

		try {
			return Response
					.ok(ObjectParser.jsonify(allStores))
					.build();
		} catch (JsonProcessingException exception) {
			return Response.serverError().build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{storeId}/stores")
	public Response getStoresByCousineId(@PathParam("storeId") Long storeId) {
		List<Product> storeProducts = productRepository.findByStoreId(storeId);

		try {
			return Response
					.ok(ObjectParser.jsonify(storeProducts))
					.build();
		} catch (JsonProcessingException exception) {
			return Response.serverError().build();
		}
	}

}
