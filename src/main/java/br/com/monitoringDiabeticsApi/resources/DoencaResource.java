package br.com.monitoringDiabeticsApi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitoringDiabeticsApi.models.Doenca;
import br.com.monitoringDiabeticsApi.repository.DoencaRespository;

@RestController
@RequestMapping("/doencas")
public class DoencaResource {

	@Autowired
	private DoencaRespository doencaRespository;

	@GetMapping
	public List<Doenca> findAll() {
		return this.doencaRespository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> findOne(@PathVariable Long codigo) {
		Doenca doenca = this.doencaRespository.findOne(codigo);
		return doenca != null ? ResponseEntity.ok(doenca) : ResponseEntity.notFound().build();
	}

}
