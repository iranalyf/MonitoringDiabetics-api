package br.com.monitoringDiabeticsApi.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.monitoringDiabeticsApi.models.Usuario;
import br.com.monitoringDiabeticsApi.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> findOne(Long codigo) {
		Usuario usuario = this.usuarioRepository.findOne(codigo);
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid Usuario usuario) {
		usuario = this.usuarioRepository.save(usuario);
		return ResponseEntity.ok(usuario);
	}

}
