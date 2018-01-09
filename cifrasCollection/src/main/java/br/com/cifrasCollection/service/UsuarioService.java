package br.com.cifrasCollection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cifrasCollection.model.Usuario;
import br.com.cifrasCollection.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> obterUsuario(String login, String senha) {
		
		List<Usuario> usuarios = this.repository.findByLoginSenha(login, senha);
		
		return usuarios;
	}
	
	public Usuario salvar(Usuario usuario) {
		return this.repository.save(usuario);
	}
}
