package br.com.cifrasCollection;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cifrasCollection.enumeration.TomMusica;
import br.com.cifrasCollection.model.Cifra;
import br.com.cifrasCollection.service.CifraService;

@Controller
public class PrincipalController {
	
	@Autowired
	private CifraService service;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("cadastrarcifras")
	public String cadastrarCifras(Model model){
		
		model.addAttribute("tons", EnumSet.allOf(TomMusica.class));
		
		return "cadastrarcifras";
	}
	
	@RequestMapping("pesquisarcifras")
	public String pesquisarCifras(Model model){
		return "pesquisarcifras";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, @RequestParam("tom")String tom, 
			@RequestParam("cantor") String cantor, Model model){
		
		Cifra novaCifra = new Cifra();
		novaCifra.setNome(nome);
		TomMusica tomMusica = TomMusica.getEnumByDescricao(tom);		
		
		if (tom != null) {
			novaCifra.setTom(tomMusica);
		}
		
		novaCifra.setCantor(cantor);
		
		service.salvar(novaCifra);
		
		Iterable<Cifra> cifras = service.obterTodos();
		
		
		model.addAttribute("cifras", cifras);
		
		return "listacifras";
		
	}
}
