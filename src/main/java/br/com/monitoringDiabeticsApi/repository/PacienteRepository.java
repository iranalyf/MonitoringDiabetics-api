package br.com.monitoringDiabeticsApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.monitoringDiabeticsApi.models.Dieta;
import br.com.monitoringDiabeticsApi.models.Medicacao;
import br.com.monitoringDiabeticsApi.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query("select sum(p.codigo) from Paciente p")
	public Long countPacientes();

	@Query("select d from Dieta d where d.paciente.codigo = ?1")
	public List<Dieta> findDietasByCodigoPaciente(Long codigo);

	@Query("select sum(p.codigo) from Paciente p where p.situacao = true")
	public Long countPacientesActives();

	@Query("from Medicacao m where m.paciente.codigo = ?1")
	public List<Medicacao> findAllMedicacoesByCodigoPacient(Long codigo);
}
