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
import com.skipthedishes.api.repository.CousineRepository;
import com.skipthedishes.test.helpers.database.DatabaseTestDataPopulator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("unit")
public class CousineControllerTest extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private WebTestClient webClient;
	
	@Autowired CousineRepository cousineRepository;
	
	private static String cousineEndpointUri;
	
	@BeforeClass
	public static void setUpClass() {
		cousineEndpointUri = "/api/v1/cousine";
		DatabaseTestDataPopulator.populateDatabase();
	}

	@Test
	public void testFindAllCousines() {
		//given
		// Nothing
		
		
		//then
		this.webClient.get().uri(cousineEndpointUri).exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody()
		.jsonPath("$").isArray();
		
		//TODO Improve this test case by veryfing the response data
	}
}
