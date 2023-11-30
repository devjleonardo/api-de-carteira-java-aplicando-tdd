package com.joseleonardo.carteira.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UsuarioCarteiraDTO {

	private Long id;
	
	@NotNull(message = "Informe o id do usuário")
	private Long usuario;
	
	@NotNull(message = "Informe o id da carteira")
	private Long carteira;
	
}
