package br.com.monitoringDiabeticsApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.monitoringDiabeticsApi.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
