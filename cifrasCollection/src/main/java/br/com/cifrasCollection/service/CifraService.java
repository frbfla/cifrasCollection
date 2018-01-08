package br.com.cifrasCollection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cifrasCollection.model.Cifra;
import br.com.cifrasCollection.repository.CifraRepository;

@Service
public class CifraService {

	@Autowired
	private CifraRepository repository;
	
	public Iterable<Cifra> obterTodos(){
		
		Iterable<Cifra> convidados = repository.findAll();
		
		return convidados;
		
	}
	
}
