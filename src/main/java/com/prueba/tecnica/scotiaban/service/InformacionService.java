package com.prueba.tecnica.scotiaban.service;

import org.springframework.http.ResponseEntity;

import com.prueba.tecnica.scotiaban.dto.RequestLogin;

public interface InformacionService {

	ResponseEntity<Object> consultarInformacion(String customerId);

	ResponseEntity<Object> login(RequestLogin request);

}
