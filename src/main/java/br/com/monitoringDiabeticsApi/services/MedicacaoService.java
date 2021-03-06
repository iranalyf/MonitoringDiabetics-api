package br.com.monitoringDiabeticsApi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.monitoringDiabeticsApi.models.Medicacao;
import br.com.monitoringDiabeticsApi.repository.MedicacaoRepository;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;

@Service
public class MedicacaoService {

	@Autowired
	private MedicacaoRepository medicacaoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Medicacao> findAll() {
		return this.medicacaoRepository.findAll();
	}

	public Medicacao findById(Integer id) {
		return this.medicacaoRepository.findOne(id);
	}

	@Transactional
	public Medicacao save(Medicacao medicacao) {
		medicacao.setDataMedicacao(LocalDate.now());
		 Medicacao medicacaoSalva = this.medicacaoRepository.save(medicacao);
		 this.pacienteRepository.updateDataUltimoRegistro(medicacao.getPaciente().getCodigo());
		 return medicacaoSalva;
	}
}
