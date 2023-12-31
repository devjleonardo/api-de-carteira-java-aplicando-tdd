package com.joseleonardo.carteira.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.joseleonardo.carteira.entity.enums.TipoItemCarteira;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ItemCarteira implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Carteira carteira;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoItemCarteira tipo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private BigDecimal valor;

	public ItemCarteira(Carteira carteira, Date data, TipoItemCarteira tipo, String descricao, BigDecimal valor) {
		this.carteira = carteira;
		this.data = data;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
	}

}
