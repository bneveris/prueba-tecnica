package com.prueba.tecnica.scotiaban.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.prueba.tecnica.scotiaban.dto.RequestLogin;
import com.prueba.tecnica.scotiaban.dto.ResponseInformacionDto;


public class InformacionServiceImplTest {

	@InjectMocks
	InformacionServiceImpl injectMock;
	
	
	@BeforeEach
	public void contextLoads() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void consultarInformacion() {
		String customerId = "ABCD1234";
		
		ResponseEntity<Object> response = injectMock.consultarInformacion(customerId);
		assertEquals(response.getBody().getClass(), ResponseInformacionDto.class);
	}
	
	@Test
	void login() {
		RequestLogin request = new RequestLogin();
		request.setPassword("ABCD1234");
		request.setUsername("Perez");
		
		ResponseEntity<Object> response = injectMock.login(request);
		assertEquals(response.getBody().getClass(), ResponseInformacionDto.class);
	}
}
