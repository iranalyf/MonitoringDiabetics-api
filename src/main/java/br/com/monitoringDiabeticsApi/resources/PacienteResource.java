package br.com.monitoringDiabeticsApi.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.monitoringDiabeticsApi.models.Paciente;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;
import br.com.monitoringDiabeticsApi.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public List<Paciente> findAll() {
		return this.pacienteRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> findOne(@PathVariable Long codigo) {
		Paciente paciente = this.pacienteRepository.findOne(codigo);
		return paciente != null ? ResponseEntity.ok(paciente) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid Paciente paciente, HttpServletResponse res) {
		paciente = this.pacienteRepository.save(paciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(paciente.getCodigo()).toUri();
		res.setHeader("location", uri.toASCIIString());
		return ResponseEntity.ok(paciente);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		this.pacienteRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Paciente> update(@Valid @RequestBody Paciente paciente, @PathVariable Long codigo) {
		paciente = this.pacienteService.update(paciente, codigo);
		return ResponseEntity.ok(paciente);
	}
}
