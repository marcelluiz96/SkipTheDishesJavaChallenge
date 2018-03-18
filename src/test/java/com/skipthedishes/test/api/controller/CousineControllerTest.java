package com.skipthedishes.test.api.controller;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.skipthedishes.api.App;
import com.skipthedishes.api.model.Cousine;
import com.skipthedishes.api.repository.CousineRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unit")
public class CousineControllerTest extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private WebTestClient webClient;
	
	@Autowired CousineRepository cousineRepository;
	
	private static String cousineEndpointUri;
	private static String cousineStoresByIdUri;
	private static String cousineFullTextSearchUri;
	
	@BeforeClass
	public static void setUpClass() {
		cousineEndpointUri = "/api/v1/cousine";
		cousineStoresByIdUri = cousineEndpointUri + "/{cousineId}/stores";
		cousineFullTextSearchUri = cousineEndpointUri + "/search/{searchKeywords}";
	}

	@Test
	public void testFindAllCousines() {
		// given/then
		// As is
		
		
		//then
		this.webClient.get().uri(cousineEndpointUri).exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody()
		.jsonPath("$").isArray();
		
		//TODO Improve this test case by veryfing the response data
	}
	
	@Test
	public void testFindStoresByCousineIdOnExistingId() {
		//given
		Long existingId = new Long(1);
		
		// when
		Long expectedId = existingId;
		String expectedName = "Cousine1";
		
		// then
		this.webClient.get().uri(cousineStoresByIdUri, existingId)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody().jsonPath("$").isArray();
	}
	
	// This test failed intentionally. The API returned an error 5xx when it should return a 404 Not found
	@Test
	public void testFindStoresByCousineIdOnNonExistingId() {
		// given
		Long nonExistingId = new Long(100);
		
		// when
		Long expectedId = nonExistingId;
		
		// then
		this.webClient.get().uri(cousineStoresByIdUri, nonExistingId).exchange()
		.expectStatus().isNotFound()
		.expectHeader().contentType(MediaType.APPLICATION_JSON);
	}
	
	@Test
	public void testFindByTextOnFindableText() {
		// given
		String keywords = "cousine 1"; // The name of the first mocked Cousine
		
		// when
		Long expectedId = 1l;
		
		// then
		
		this.webClient.get().uri(cousineFullTextSearchUri, keywords)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBodyList(Cousine.class);
	}
}
