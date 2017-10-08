package br.com.monitoringDiabeticsApi.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "horario_medicacao")
public class HorarioMedicacao {

	private Integer idHorario;
	private LocalDateTime horario;
	private LocalDate data;
	
	private Medicacao medicacao;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	@ManyToOne
	@JoinColumn(name = "codigo_medicacao")
	public Medicacao getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(Medicacao medicacao) {
		this.medicacao = medicacao;
	}

	@NotNull
	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	
	@NotNull
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHorario == null) ? 0 : idHorario.hashCode());
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
		HorarioMedicacao other = (HorarioMedicacao) obj;
		if (idHorario == null) {
			if (other.idHorario != null)
				return false;
		} else if (!idHorario.equals(other.idHorario))
			return false;
		return true;
	}

}
