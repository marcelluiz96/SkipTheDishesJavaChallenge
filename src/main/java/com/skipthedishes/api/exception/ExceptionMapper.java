//package com.skipthedishes.api.exception;
//
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//
//public class CheckedExceptionMapper implements ExceptionMapper<> {
//
//	public Response toResponse(AppException ex) {
//		return Response.status(ex.getStatus())
//				.entity(new ErrorMessage(ex))
//				.type(MediaType.APPLICATION_JSON).
//				build();
//	}
//
//}
