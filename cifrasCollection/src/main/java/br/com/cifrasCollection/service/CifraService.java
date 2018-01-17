package br.com.cifrasCollection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cifrasCollection.model.Cifra;
import br.com.cifrasCollection.model.Usuario;
import br.com.cifrasCollection.repository.CifraRepository;

@Service
public class CifraService {

	@Autowired
	private CifraRepository repository;
	
	public Cifra salvar(Cifra novaCifra) {
		return this.repository.save(novaCifra);		
	}
	
	public List<Cifra> obterCifrasFiltro(String filtro, Usuario usuario){
		return this.repository.findByFiltro(filtro, usuario);
	}

	public Iterable<Cifra> obterTodos() {
		return this.repository.findAll();
	}

	public Cifra obterCifraPorId(Long id) {
		return this.repository.findOne(id);
	}
	
}
