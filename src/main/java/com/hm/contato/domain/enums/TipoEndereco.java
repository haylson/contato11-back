package com.hm.contato.domain.enums;

public enum TipoEndereco {
	
	TRABALHO(0,"TRABALHO"), RESIDENCIA(1, "RESIDENCIA");
	
	private Integer codigo;
	private String descricao;
	
	private TipoEndereco(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoEndereco toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoEndereco te : TipoEndereco.values()) {
			if(cod.equals(te.getCodigo())) {
				return te;
			}
		}
		
		throw new IllegalArgumentException("Tipo Endereço Inválido");
	}
	
	

}
