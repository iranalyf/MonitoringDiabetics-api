package br.com.monitoringDiabeticsApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.monitoringDiabeticsApi.models.Medicacao;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Integer> {

	@Modifying
	@Query("from Medicacao m where m.paciente.codigo = ?1")
	public List<Medicacao> findMedicacoesByCodigoPaciente(Long codigo);
}
