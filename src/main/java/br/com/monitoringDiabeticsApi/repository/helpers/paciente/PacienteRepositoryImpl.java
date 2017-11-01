package br.com.monitoringDiabeticsApi.repository.helpers.paciente;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.monitoringDiabeticsApi.dto.PacienteMes;

public class PacienteRepositoryImpl implements PacienteRepositoryHelper {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void updateDataUltimoRegistro(Long codigoPaciente) {
		this.manager
			.createQuery("update Paciente p set p.ultimoRegistro = :dataAtual where p.codigo = :id")
			.setParameter("id", codigoPaciente)
			.setParameter("dataAtual", LocalDate.now())
			.executeUpdate();		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PacienteMes> pacientesPorMes() {		
		return this.manager
				.createNamedQuery("Pacientes.totalPorMes").getResultList();
	}	
}
