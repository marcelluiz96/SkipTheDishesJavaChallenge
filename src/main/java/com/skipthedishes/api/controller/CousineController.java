package com.skipthedishes.api.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.skipthedishes.api.model.Cousine;
import com.skipthedishes.api.model.Store;
import com.skipthedishes.api.repository.CousineRepository;
import com.skipthedishes.api.repository.StoreRepository;
import com.skipthedishes.api.service.CousineService;
import com.skipthedishes.api.utils.ObjectParser;

@Component
@Path("/cousine")
public class CousineController {



	@Autowired
	private CousineService cousineService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response getAllCousines() throws JsonProcessingException {

		Optional<List<Cousine>> allCousinesOptional = cousineService.listAll();	
		List<Cousine> allCousines = allCousinesOptional.orElse(null);

		if (allCousines != null) {

			try {
				return Response
						.ok(ObjectParser.jsonify(allCousines))
						.build();
			} catch (JsonProcessingException exception) {
				return Response.serverError().build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{cousineId}/stores")
	public Response getStoresByCousineId(@PathParam("cousineId") Long cousineId) {

		Optional<List<Store>> foundStoresOptional = cousineService.findStoresByCousineId(cousineId);

		List<Store> foundStores = foundStoresOptional.orElse(null);

		if (foundStores != null) {
			try {
				return Response
						.ok(ObjectParser.jsonify(foundStores))
						.build();
			} catch (JsonProcessingException exception) {
				return Response
						.serverError()
						.build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{searchKeywords}")
	public Response getSearchedCousines(@PathParam("searchKeywords") String searchKeywords) {

		Optional<List<Cousine>> foundCousinesOptional = cousineService.findByKeywords(searchKeywords);

		List<Cousine> foundCousines = foundCousinesOptional.orElse(null);

		if (foundCousines != null) {
			try {
				return Response
						.ok(ObjectParser.jsonify(foundCousines))
						.build();
			} catch (JsonProcessingException exception) {
				return Response.serverError().build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}
}
