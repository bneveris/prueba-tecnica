package com.prueba.tecnica.scotiaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.scotiaban.dto.RequestLogin;
import com.prueba.tecnica.scotiaban.service.InformacionService;


@RestController
@RequestMapping("Scotiabank-Colpatria")
public class InformacionController {
	
	@Autowired
	InformacionService informacionService;

	/**
	 * Metodo encargado de traer la informacion personal
	 * @param request
	 * @param usuario
	 * @return
	 */
	@PostMapping("/consultarInformacion")
	public ResponseEntity<Object> consultatInformacion(@RequestHeader("customerId") String customerId) {

		return informacionService.consultarInformacion(customerId);

	}
	
	
	/**
	 * Metodo encargado de traer la informacion personal
	 * @param request
	 * @param usuario
	 * @return
	 */
	@PostMapping("/loginUsuarios")
	public ResponseEntity<Object> login(@RequestBody RequestLogin request) {

		return informacionService.login(request);

	}
}
