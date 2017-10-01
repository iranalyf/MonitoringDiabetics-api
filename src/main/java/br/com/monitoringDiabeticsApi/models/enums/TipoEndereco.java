package br.com.monitoringDiabeticsApi.models.enums;

public enum TipoEndereco {
	RUA("Rua"), AVENIDA("Avenida"), QUADRA("Quadra"), APARTAMENTO("Apartamento");

	private String descricao;

	TipoEndereco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
