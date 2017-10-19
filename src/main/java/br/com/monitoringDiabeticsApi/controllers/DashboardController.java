package br.com.monitoringDiabeticsApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitoringDiabeticsApi.repository.PacienteRepository;
import br.com.monitoringDiabeticsApi.repository.UsuarioRepository;

@RequestMapping("/dashboard")
@RestController
public class DashboardController {

	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/allUsers")
	public ResponseEntity<?> findAllUsuarios() {
		Long usersAll = this.usuarioRepository.countUsuarios();
		return ResponseEntity.ok(usersAll);
	}

	@GetMapping("/allPacientesActives")
	public ResponseEntity<?> findAllPacientesAtivos() {
		Long allPacientesActives = this.pacienteRepository.countPacientesActives();
		return ResponseEntity.ok(allPacientesActives);
	}

	@GetMapping("/allPacientes")
	public ResponseEntity<?> findAllPacientes() {
		Long allPacientes = this.pacienteRepository.countPacientes();
		return ResponseEntity.ok(allPacientes);

	}
}
