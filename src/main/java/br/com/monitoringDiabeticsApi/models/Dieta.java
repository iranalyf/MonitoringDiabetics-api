package br.com.monitoringDiabeticsApi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "dieta")
public class Dieta {

	private Integer IdDieta;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String descricao;
	private String observacao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdDieta() {
		return IdDieta;
	}

	public void setIdDieta(Integer idDieta) {
		IdDieta = idDieta;
	}

	@NotNull
	@Column(name = "data_inicio")
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	@NotNull
	@Column(name = "data_fim")
	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	@NotEmpty
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdDieta == null) ? 0 : IdDieta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dieta other = (Dieta) obj;
		if (IdDieta == null) {
			if (other.IdDieta != null)
				return false;
		} else if (!IdDieta.equals(other.IdDieta))
			return false;
		return true;
	}

}
