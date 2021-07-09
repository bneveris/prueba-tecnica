package com.prueba.tecnica.scotiaban.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.scotiaban.dto.ErroresDto;
import com.prueba.tecnica.scotiaban.dto.RequestLogin;
import com.prueba.tecnica.scotiaban.dto.ResponseInformacionDto;
import com.prueba.tecnica.scotiaban.service.InformacionService;
import com.prueba.tecnica.scotiaban.utils.InformacionConstantes;

@Service
public class InformacionServiceImpl implements InformacionService {

	@Override
	public ResponseEntity<Object> consultarInformacion(String customerId) {
				
		ResponseInformacionDto response = new ResponseInformacionDto();
		
		try {
			
			boolean existeId =customers().contains(customerId);
			
			if(existeId) {
				
				Map<String, String> info = informacionPersonal();
				
				response.setTipoIdentificacion(info.get(customerId+"_ti"));
				response.setNumeroIdentificacion(Integer.parseInt(info.get(customerId+"_nro")));
				response.setPrimerNombre(info.get(customerId+"_pn") != null ? info.get(customerId+"_pn") : "");
				response.setSegundoNombre(info.get(customerId+"_sn") != null ? info.get(customerId+"_sn") : "");
				response.setPrimerApellido(info.get(customerId+"_pa") != null ? info.get(customerId+"_pa") : "");
				response.setSegundoApellido(info.get(customerId+"_sa") != null ? info.get(customerId+"_sa") : "");
				
				return ResponseEntity.ok(response);
				
			}else {

				return ResponseEntity.badRequest().body(errores(InformacionConstantes.CUSTOMER_ID));
				
			}
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(errores(InformacionConstantes.ERROR_DESCONOCIDO));
			
		}

	}

	@Override
	public ResponseEntity<Object> login(RequestLogin request) {
		
		try {
			
			String apellido =null;
			
			if(customers().contains(request.getPassword())) {
				
				Map<String, String> info = informacionPersonal();
				
				apellido=info.get(request.getPassword()+"_pa");
				
				
			}else {
				
				return ResponseEntity.badRequest().body(errores(InformacionConstantes.CREDENCIALES));
				
			}
			
			if(apellido != null && apellido.equals(request.getUsername())) {
				
				return ResponseEntity.ok(consultarInformacion(request.getPassword()).getBody());
				
			}else {
				
				return ResponseEntity.badRequest().body(errores(InformacionConstantes.CREDENCIALES));
				
			}
			
			
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(errores(InformacionConstantes.ERROR_DESCONOCIDO));
			
		}

	}
	
	/**
	 * metodo para el manejo de errores
	 * @param mensajeError
	 * @return
	 */
	public ErroresDto errores(String mensajeError) {
		
		ErroresDto error = new ErroresDto();
		
		error.setMensajeError(mensajeError);
		
		return error;
	}
	
	/**
	 * metodo donde se crean los customers id
	 * @return
	 */
	public List<String> customers(){
		
		List<String> listaCustomerId = new ArrayList<>();
		
		listaCustomerId.add(InformacionConstantes.CUSTOMER_ID_1);
		listaCustomerId.add(InformacionConstantes.CUSTOMER_ID_2);
		
		return listaCustomerId;
	}
	
	
	/**
	 * metodo donde se tiene la informacion personal
	 * @return
	 */
	public Map<String, String> informacionPersonal(){
		
		Map<String, String> info = new HashMap<>();
		
		info.put(InformacionConstantes.CUSTOMER_ID_1+"_ti", "CC");
		info.put(InformacionConstantes.CUSTOMER_ID_1+"_nro", "1024587241");
		info.put(InformacionConstantes.CUSTOMER_ID_1+"_pn", "Pepito");
		info.put(InformacionConstantes.CUSTOMER_ID_1+"_pa", "Perez");
		
		info.put(InformacionConstantes.CUSTOMER_ID_2+"_ti", "NIT");
		info.put(InformacionConstantes.CUSTOMER_ID_2+"_nro", "80012345");
		info.put(InformacionConstantes.CUSTOMER_ID_2+"_pn", "Juliana");
		info.put(InformacionConstantes.CUSTOMER_ID_2+"_pa", "Galvis");
		
		return info;
	}

}
