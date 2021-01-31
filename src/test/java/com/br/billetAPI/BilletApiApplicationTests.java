package com.br.billetAPI;

import com.br.billetAPI.model.Billet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BilletApiApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}


	@Test
	void shouldPersistCreatedEntityOnBilletPost(){
		Billet requestedBillet = this.getOneCarEntityForTests();
		Billet createdBillet = this.restTemplate.postForObject("http://localhost:" + port + "/boleto", requestedBillet , Billet.class);
		assertEquals(createdBillet.getCarId(), requestedBillet.getCarId());
	}

	private Billet getOneCarEntityForTests() {
		Billet billet = new Billet();
		billet.setCarId(1L);
		return billet;
	}

}
