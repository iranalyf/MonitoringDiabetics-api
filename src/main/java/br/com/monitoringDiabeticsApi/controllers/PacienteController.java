package br.com.monitoringDiabeticsApi.controllers;

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

import br.com.monitoringDiabeticsApi.dto.PacienteMes;
import br.com.monitoringDiabeticsApi.models.Dieta;
import br.com.monitoringDiabeticsApi.models.Medicacao;
import br.com.monitoringDiabeticsApi.models.Paciente;
import br.com.monitoringDiabeticsApi.repository.DietaRepository;
import br.com.monitoringDiabeticsApi.repository.MedicacaoRepository;
import br.com.monitoringDiabeticsApi.repository.PacienteRepository;
import br.com.monitoringDiabeticsApi.services.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private DietaRepository dietaRepository;
	
	@Autowired
	private MedicacaoRepository medicacaoRepository;

	@GetMapping
	public ResponseEntity<List<Paciente>> findAll() {
		return ResponseEntity.status(200).body(this.pacienteRepository.findAll());
	}
	
	@GetMapping("/pacientesPorMes")
	public ResponseEntity<?> pacientesPorMes(){
		
		List<PacienteMes> pacientesPorMes = this.pacienteService.pacientesPorMes();
		return !pacientesPorMes.isEmpty() 
				? ResponseEntity.ok(pacientesPorMes) 
				: ResponseEntity.noContent().build();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> findOne(@PathVariable Long codigo) {

		Paciente paciente = this.pacienteRepository.findOne(codigo);
		return paciente != null 
				? ResponseEntity.ok(paciente) 
				: ResponseEntity.notFound().build();
	}

	@GetMapping("/{codigo}/allMedicacoes")
	public ResponseEntity<?> findAllMedicacoesByIdPaciente(@PathVariable Long codigo) {

		List<Medicacao> medicacoesByPacient = this.pacienteRepository.findAllMedicacoesByCodigoPacient(codigo);
		return ResponseEntity.ok(medicacoesByPacient);
	}

	@GetMapping("/{id}/dietas")
	public ResponseEntity<List<Dieta>> findAllDietasByPaciente(@PathVariable Long id){
		 List<Dieta> dietas = dietaRepository.findDietasByCodigoPaciente(id);
		 return dietas.isEmpty() 
				? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
				: ResponseEntity.ok(dietas);
	}
	
	@GetMapping("/{id}/medicacoes")
	public ResponseEntity<List<Medicacao>> findAllMedicacoesByPaciente(@PathVariable Long id){
		List<Medicacao> medicacoes = this.medicacaoRepository.findMedicacoesByCodigoPaciente(id);
		return medicacoes.isEmpty()
				? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
				: ResponseEntity.ok(medicacoes);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Paciente paciente, HttpServletResponse res) {
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
		try {
			Paciente pacienteSalvo = this.pacienteService.update(paciente, codigo);
			return ResponseEntity.ok(pacienteSalvo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
