package br.com.monitoringDiabeticsApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.monitoringDiabeticsApi.models.Dieta;
import br.com.monitoringDiabeticsApi.models.Medicacao;
import br.com.monitoringDiabeticsApi.models.Paciente;
import br.com.monitoringDiabeticsApi.repository.helpers.paciente.PacienteRepositoryHelper;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteRepositoryHelper {

	@Query("select count(p.codigo) from Paciente p")
	public Long countPacientes();

	@Query("select d from Dieta d where d.paciente.codigo = ?1")
	public List<Dieta> findDietasByCodigoPaciente(Long codigo);

	@Query("select count(p.codigo) from Paciente p where p.situacao = 'ATIVO'")
	public Long countPacientesActives();

	@Query("from Medicacao m where m.paciente.codigo = ?1")
	public List<Medicacao> findAllMedicacoesByCodigoPacient(Long codigo);

	@Modifying
	@Query("update Paciente p set p.situacao = 'INATIVO' where p.codigo = ?1")
	public void atualizarSituacaoPacienteInativo(Long codigoPaciente);

}
