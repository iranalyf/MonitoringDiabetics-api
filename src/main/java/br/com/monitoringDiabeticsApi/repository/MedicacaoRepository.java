package br.com.monitoringDiabeticsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monitoringDiabeticsApi.models.Medicacao;

public interface MedicacaoRepository extends JpaRepository<Medicacao, Integer> {

}
