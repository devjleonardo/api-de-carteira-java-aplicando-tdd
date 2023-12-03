package com.joseleonardo.carteira.entity.enums;

public enum TipoItemCarteira {

	EN("ENTRADA"),
	SD("SAÍDA");
	
	private final String descricao;

	private TipoItemCarteira(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoItemCarteira getEnum(String descricao) {
		for (TipoItemCarteira tipoItemCarteira : values()) {
			if (tipoItemCarteira.getDescricao().equals(descricao)) {
				return tipoItemCarteira;
			}
		}
		
		return null;
	}
	
}
