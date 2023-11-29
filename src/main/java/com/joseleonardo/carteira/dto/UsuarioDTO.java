package com.joseleonardo.carteira.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long id;
	
	@Length(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
	private String nome;
	
	@Email(message = "Email inválido")
	private String email;
	
	@NotNull
	@Length(min = 6, message = "A senha deve conter no mínimo 6 caracteres")
	private String senha;

}
