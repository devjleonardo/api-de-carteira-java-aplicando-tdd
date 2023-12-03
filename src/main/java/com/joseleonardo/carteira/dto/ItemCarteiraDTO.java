package com.joseleonardo.carteira.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ItemCarteiraDTO {

	private Long id;

	@NotNull(message = "Informe o id da carteira")
	private Long carteiraId;

	@NotNull(message = "Informe uma data")
	private Date data;

	@NotNull(message = "Informe um tipo")
	private String tipo;

	@NotNull(message = "Informe uma descrição")
	@Length(min = 5, message = "A descrição deve ter no mínimo5 caracteres")
	private String descricao;

	@NotNull(message = "Insira um valor")
	private BigDecimal valor;

}
