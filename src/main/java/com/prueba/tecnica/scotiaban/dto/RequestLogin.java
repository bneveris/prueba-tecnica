package com.prueba.tecnica.scotiaban.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestLogin {

	private String password;
	private String username;
}
