package br.com.monitoringDiabeticsApi.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.monitoringDiabeticsApi.models.Paciente;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping
	public List<Paciente> findAll() {
		return this.pacienteRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> findOne(@PathVariable Long codigo) {
		Paciente paciente = this.pacienteRepository.findOne(codigo);
		return ResponseEntity.ok(paciente);
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid Paciente paciente) {
		paciente = this.pacienteRepository.save(paciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(paciente.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
