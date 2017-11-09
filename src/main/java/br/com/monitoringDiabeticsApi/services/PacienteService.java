package br.com.monitoringDiabeticsApi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.monitoringDiabeticsApi.dto.PacienteMes;
import br.com.monitoringDiabeticsApi.models.Paciente;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> findAll() {
		return this.pacienteRepository.findAll();
	}

	public List<PacienteMes> pacientesPorMes() {
		return this.pacienteRepository.pacientesPorMes();
	}

	@Transactional
	public Paciente update(Paciente paciente, Long codigo) {
		Paciente pacienteSalvo = this.pacienteRepository.findOne(codigo);
		BeanUtils.copyProperties(paciente, pacienteSalvo, "codigo");
		return this.pacienteRepository.save(pacienteSalvo);
	}

	@Transactional
	public Paciente save(Paciente paciente) {
		paciente.setDataCadastro(LocalDate.now());
		return this.pacienteRepository.save(paciente);
	}

	@Transactional
	public void atualizarSituacaoPacienteInativo(Long codigoPaciente) {
		this.pacienteRepository.atualizarSituacaoPacienteInativo(codigoPaciente);
	}
}
