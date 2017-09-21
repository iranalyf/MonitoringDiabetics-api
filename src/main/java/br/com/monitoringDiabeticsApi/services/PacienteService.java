package br.com.monitoringDiabeticsApi.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.monitoringDiabeticsApi.models.Paciente;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Transactional
	public Paciente update(Paciente paciente, Long codigo) {
		Paciente pacienteSalvo = this.pacienteRepository.findOne(codigo);
		BeanUtils.copyProperties(paciente, pacienteSalvo, "codigo");
		return this.pacienteRepository.save(pacienteSalvo);
	}
}
