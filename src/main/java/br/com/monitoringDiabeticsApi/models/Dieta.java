package br.com.monitoringDiabeticsApi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "dieta")
public class Dieta {

	private Integer codigo;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String descricao;
	private String cafeManha;
	private String lancheManha;
	private String almoco;
	private String sobremesaAlmoco;
	private String lancheTarde;
	private String janta;
	private String lancheNoite;
	private String qtdeAguaDiaria;
	private String observacao;

	private Paciente paciente;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "data_inicio")
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

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

	@NotEmpty
	@Column(name = "cafe_manha")
	public String getCafeManha() {
		return cafeManha;
	}

	public void setCafeManha(String cafeManha) {
		this.cafeManha = cafeManha;
	}

	@NotEmpty
	@Column(name = "lanche_manha")
	public String getLancheManha() {
		return lancheManha;
	}

	public void setLancheManha(String lancheManha) {
		this.lancheManha = lancheManha;
	}

	@NotEmpty
	@Column(name = "almoco")
	public String getAlmoco() {
		return almoco;
	}

	public void setAlmoco(String almoco) {
		this.almoco = almoco;
	}

	@NotEmpty
	@Column(name = "sobremesa_almoco")
	public String getSobremesaAlmoco() {
		return sobremesaAlmoco;
	}

	public void setSobremesaAlmoco(String sobremesaAlmoco) {
		this.sobremesaAlmoco = sobremesaAlmoco;
	}

	@NotEmpty
	@Column(name = "lanche_tarde")
	public String getLancheTarde() {
		return lancheTarde;
	}

	public void setLancheTarde(String lancheTarde) {
		this.lancheTarde = lancheTarde;
	}

	@NotEmpty
	@Column(name = "janta")
	public String getJanta() {
		return janta;
	}

	public void setJanta(String janta) {
		this.janta = janta;
	}

	@NotEmpty
	@Column(name = "lanche_noite")
	public String getLancheNoite() {
		return lancheNoite;
	}

	public void setLancheNoite(String lancheNoite) {
		this.lancheNoite = lancheNoite;
	}

	@NotEmpty
	@Column(name = "qtde_agua_diaria")
	public String getQtdeAguaDiaria() {
		return qtdeAguaDiaria;
	}

	public void setQtdeAguaDiaria(String qtdeAguaDiaria) {
		this.qtdeAguaDiaria = qtdeAguaDiaria;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

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
		Dieta other = (Dieta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
