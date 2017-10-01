package br.com.monitoringDiabeticsApi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.monitoringDiabeticsApi.models.Usuario;

public class UserSistema extends User {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UserSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
