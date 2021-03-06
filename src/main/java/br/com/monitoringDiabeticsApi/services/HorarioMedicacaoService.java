package br.com.monitoringDiabeticsApi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.monitoringDiabeticsApi.models.HorarioMedicacao;
import br.com.monitoringDiabeticsApi.repository.HorarioMedicacaoRepository;

@Service
public class HorarioMedicacaoService {

	@Autowired
	private HorarioMedicacaoRepository horarioMedicacaoRepository;

	public List<HorarioMedicacao> findAll() {
		return this.horarioMedicacaoRepository.findAll();
	}

	public HorarioMedicacao findById(Integer id) {
		return this.horarioMedicacaoRepository.findOne(id);
	}

	@Transactional
	public HorarioMedicacao save(HorarioMedicacao horarioMedicacao) {
		return this.horarioMedicacaoRepository.save(horarioMedicacao);
	}

	@Transactional
	public void setFimMedicacao(Integer idHorarioMedicacao) {
		HorarioMedicacao horarioMedicacaoSalvo = this.horarioMedicacaoRepository
				.findOne(idHorarioMedicacao);
		horarioMedicacaoSalvo.setDataFim(LocalDate.now());
		this.horarioMedicacaoRepository.save(horarioMedicacaoSalvo);

	}
}
