package br.com.cifrasCollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cifrasCollection.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("SELECT user FROM usuario user where user.login = :login and user.senha=:senha")
	List<Usuario> findByLoginSenha(@Param("login")String login, @Param("senha") String senha);


}
