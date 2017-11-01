package br.com.monitoringDiabeticsApi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.monitoringDiabeticsApi.models.Dieta;
import br.com.monitoringDiabeticsApi.repository.DietaRepository;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;

@Service
public class DietaService {

	@Autowired
	private DietaRepository dietaRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Dieta> findAll() {
		return this.dietaRepository.findAll();
	}

	public Dieta findById(Integer id) {
		return this.dietaRepository.findOne(id);
	}

	@Transactional
	public Dieta save(Dieta dieta) {
		dieta.setDataInicio(LocalDate.now());
		Dieta dietaSalva = this.dietaRepository.save(dieta);
		System.out.println(dietaSalva.getPaciente().getPrimeiroNome());
		this.pacienteRepository.updateDataUltimoRegistro(dietaSalva.getPaciente().getCodigo());
		return dietaSalva;
	}
}
