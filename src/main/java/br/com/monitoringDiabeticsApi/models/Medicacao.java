package br.com.monitoringDiabeticsApi.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "medicacao")
public class Medicacao {

	private Integer idMedicacao;
	private String descricao;
	private LocalDate dataMedicacao;
	private String observacao;

	private List<HorarioMedicacao> horariosMedicacoes = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdMedicacao() {
		return idMedicacao;
	}

	public void setIdMedicacao(Integer idMedicacao) {
		this.idMedicacao = idMedicacao;
	}

	@NotEmpty
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull
	public LocalDate getDataMedicacao() {
		return dataMedicacao;
	}

	public void setDataMedicacao(LocalDate dataMedicacao) {
		this.dataMedicacao = dataMedicacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@OneToMany(mappedBy = "medicacao", fetch = FetchType.EAGER)
	public List<HorarioMedicacao> getHorariosMedicacoes() {
		return horariosMedicacoes;
	}

	public void setHorariosMedicacoes(List<HorarioMedicacao> horariosMedicacoes) {
		this.horariosMedicacoes = horariosMedicacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMedicacao == null) ? 0 : idMedicacao.hashCode());
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
		Medicacao other = (Medicacao) obj;
		if (idMedicacao == null) {
			if (other.idMedicacao != null)
				return false;
		} else if (!idMedicacao.equals(other.idMedicacao))
			return false;
		return true;
	}

}
