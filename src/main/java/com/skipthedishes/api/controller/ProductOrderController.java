package com.skipthedishes.api.controller;

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
import com.skipthedishes.api.model.OrderItem;
import com.skipthedishes.api.repository.ProductOrderRepository;

@Component
@Path("/order")
public class ProductOrderController {

	@Autowired
	ProductOrderRepository orderRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{orderId}")
	public Response getProductOrderByOrderId(@PathParam("orderId") Long orderId) {
		Optional<OrderItem> orderOptional = orderRepository.findById(orderId);

		try {
			return Response
					.ok(orderOptional
							.get()
							.asJsonString())
					.build();

		} catch (JsonProcessingException exception) {
			return Response
					.serverError()
					.build();
		}
	}

}
