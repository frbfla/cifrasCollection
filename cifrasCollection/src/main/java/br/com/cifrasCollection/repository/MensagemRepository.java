package br.com.cifrasCollection.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cifrasCollection.model.Mensagem;

public interface MensagemRepository extends CrudRepository<Mensagem, Long> {
	
}
