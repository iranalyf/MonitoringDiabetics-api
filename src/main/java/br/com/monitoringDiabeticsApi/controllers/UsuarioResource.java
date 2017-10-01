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

import br.com.monitoringDiabeticsApi.models.Usuario;
import br.com.monitoringDiabeticsApi.repository.UsuarioRepository;
import br.com.monitoringDiabeticsApi.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<?> findOne(@PathVariable Long codigo) {
		Usuario usuario = this.usuarioRepository.findOne(codigo);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody @Valid Usuario usuario, HttpServletResponse res) {
		usuario = this.usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(usuario.getCodigo()).toUri();
		res.setHeader("location", uri.toASCIIString());
		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long codigo) {
		this.usuarioRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario, @PathVariable Long codigo) {
		usuario = this.usuarioService.update(codigo, usuario);
		return ResponseEntity.ok(usuario);
	}

}
