package br.com.monitoringDiabeticsApi.models.enums;

public enum Situacao {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	Situacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
