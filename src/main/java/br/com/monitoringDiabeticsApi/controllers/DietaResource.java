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

import br.com.monitoringDiabeticsApi.models.Dieta;
import br.com.monitoringDiabeticsApi.services.DietaService;

@RestController
@RequestMapping("/dietas")
public class DietaResource {

	@Autowired
	private DietaService dietaService;

	@GetMapping
	public List<Dieta> findAll() {
		return this.dietaService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Dieta dieta = this.dietaService.findById(id);
		return dieta != null ? ResponseEntity.ok(dieta) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Dieta> save(@Valid @RequestBody Dieta dieta) {
		dieta = this.dietaService.save(dieta);
		return ResponseEntity.ok(dieta);
	}
}
