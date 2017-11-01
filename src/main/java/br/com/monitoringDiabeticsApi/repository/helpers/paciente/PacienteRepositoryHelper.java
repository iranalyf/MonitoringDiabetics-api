package br.com.monitoringDiabeticsApi.repository.helpers.paciente;

import java.util.List;

import br.com.monitoringDiabeticsApi.dto.PacienteMes;

public interface PacienteRepositoryHelper {

	public void updateDataUltimoRegistro(Long codigoPaciente);
	
	public List<PacienteMes> pacientesPorMes();
}
