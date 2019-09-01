package br.com.sigaachave.enums;

public enum TipoPapel {
	
	USUARIO("Usuario"),
	COORDENADOR("Coordenador"),
	ADMIN("Administrador");
	
	private String descricao;
	
	TipoPapel(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
