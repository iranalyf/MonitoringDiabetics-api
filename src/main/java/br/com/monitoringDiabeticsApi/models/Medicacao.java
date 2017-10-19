package br.com.monitoringDiabeticsApi.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medicacao")
public class Medicacao {

	private Integer codigo;
	private String descricao;
	private LocalDate dataMedicacao;
	private String observacao;

	private List<HorarioMedicacao> horariosMedicacoes = new ArrayList<>();

	private Paciente paciente;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@NotEmpty
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "data_medicacao")
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

	@OneToMany(mappedBy = "medicacao")
	public List<HorarioMedicacao> getHorariosMedicacoes() {
		return horariosMedicacoes;
	}

	public void setHorariosMedicacoes(List<HorarioMedicacao> horariosMedicacoes) {
		this.horariosMedicacoes = horariosMedicacoes;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "codigo_paciente", nullable = false)
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
