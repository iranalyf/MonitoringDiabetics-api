package br.com.monitoringDiabeticsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monitoringDiabeticsApi.models.HorarioMedicacao;

public interface HorarioMedicacaoRepository extends JpaRepository<HorarioMedicacao, Integer> {

}
