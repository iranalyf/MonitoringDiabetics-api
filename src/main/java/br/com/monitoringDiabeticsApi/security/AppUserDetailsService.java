package br.com.monitoringDiabeticsApi.security;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.monitoringDiabeticsApi.models.Usuario;
import br.com.monitoringDiabeticsApi.repository.UsuarioRepository;
import br.com.monitoringDiabeticsApi.security.twoWayAuthentication.TOTP;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TOTP totp;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(email);
		System.out.println("Realizou a consulta");
		Usuario usuario = usuarioOptional
				.orElseThrow(() -> new UsernameNotFoundException("Usuario e/ou Senha incorretos!"));
		
		//envia um token para realizar two way authentication
		if(usuario != null) {
			try {			
				String tokenGererated = this.totp.gerarToken(usuario.getSenha());
				System.out.println(">>>token Gerado: " + tokenGererated);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		
		return new UserSistema(usuario, new HashSet<>());
	}

}
