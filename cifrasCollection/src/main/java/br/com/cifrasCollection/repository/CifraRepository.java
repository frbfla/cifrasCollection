package br.com.cifrasCollection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cifrasCollection.model.Cifra;
import br.com.cifrasCollection.model.Usuario;

public interface CifraRepository extends CrudRepository<Cifra, Long> {
	
	@Query("SELECT distinct c FROM cifra c where (c.nome = :filtro or c.cantor = :filtro) and c.usuario = :usuario")
	List<Cifra> findByFiltro(@Param("filtro")String filtro, @Param("usuario")Usuario usuario);

}
