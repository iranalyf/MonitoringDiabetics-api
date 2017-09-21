package br.com.monitoringDiabeticsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monitoringDiabeticsApi.models.Doenca;

public interface DoencaRespository extends JpaRepository<Doenca, Long> {

}
