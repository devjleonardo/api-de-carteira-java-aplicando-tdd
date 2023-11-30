package com.joseleonardo.carteira.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class CarteiraDTO {

	private Long id;
	
	@NotNull
	@Length(min = 3)
	private String nome;
	
	@NotNull
	private BigDecimal valor;
	
}
