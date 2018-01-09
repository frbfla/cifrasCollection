package br.com.cifrasCollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cifrasCollection.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{


}
