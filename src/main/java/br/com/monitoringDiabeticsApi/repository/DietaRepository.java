package br.com.monitoringDiabeticsApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.monitoringDiabeticsApi.models.Dieta;

public interface DietaRepository extends JpaRepository<Dieta, Integer> {

	@Modifying
	@Query("from Dieta d where d.paciente.codigo = ?1")
	public List<Dieta> findDietasByCodigoPaciente(Long codigo);
}
