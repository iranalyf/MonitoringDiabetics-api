package br.com.monitoringDiabeticsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monitoringDiabeticsApi.models.Dieta;

public interface DietaRepository extends JpaRepository<Dieta, Integer> {

}
