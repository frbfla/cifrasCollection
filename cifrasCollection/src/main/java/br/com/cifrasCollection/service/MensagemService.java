package br.com.cifrasCollection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cifrasCollection.model.Mensagem;
import br.com.cifrasCollection.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository repository;
	
	public Mensagem salvar(Mensagem msg) {
		return this.repository.save(msg);		
	}
	
	public Iterable<Mensagem> obterTodos() {
		return this.repository.findAll();
	}

	public Mensagem obterMensagemPorId(Long id) {
		return this.repository.findOne(id);
	}
	
}
