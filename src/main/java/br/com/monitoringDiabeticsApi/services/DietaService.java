package br.com.monitoringDiabeticsApi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.monitoringDiabeticsApi.models.Dieta;
import br.com.monitoringDiabeticsApi.repository.DietaRepository;

@Service
public class DietaService {

	@Autowired
	private DietaRepository dietaRepository;

	public List<Dieta> findAll() {
		return this.dietaRepository.findAll();
	}

	public Dieta findById(Integer id) {
		return this.dietaRepository.findOne(id);
	}

	@Transactional
	public Dieta save(Dieta dieta) {
		dieta.setDataInicio(LocalDate.now());
		System.out.println(dieta.getDataInicio());
		return this.dietaRepository.save(dieta);
	}
}
