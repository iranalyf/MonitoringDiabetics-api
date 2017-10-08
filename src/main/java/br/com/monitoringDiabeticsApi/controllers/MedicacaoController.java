package br.com.monitoringDiabeticsApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitoringDiabeticsApi.models.Medicacao;
import br.com.monitoringDiabeticsApi.services.MedicacaoService;

@RestController
@RequestMapping("/medicacoes")
public class MedicacaoController {

	@Autowired
	private MedicacaoService medicacaoService;

	@GetMapping
	public List<Medicacao> findAll() {
		return this.medicacaoService.findAll();
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Medicacao medicacao = this.medicacaoService.findById(id);
		return medicacao != null ? ResponseEntity.ok(medicacao) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Medicacao> save(@Valid @RequestBody Medicacao medicacao) {
		medicacao = this.medicacaoService.save(medicacao);
		return ResponseEntity.ok(medicacao);
	}
}
