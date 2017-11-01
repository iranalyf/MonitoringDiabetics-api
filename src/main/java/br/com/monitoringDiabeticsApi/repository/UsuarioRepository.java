package br.com.monitoringDiabeticsApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.monitoringDiabeticsApi.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
	@Query("select count(u.codigo) from Usuario u")
	public Long countUsuarios();
}
