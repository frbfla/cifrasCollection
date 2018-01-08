package br.com.cifrasCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("listacifras")
	public String listaCifras(Model model){
		
		Iterable<Cifra> cifras = service.obterTodos();
		
		model.addAttribute("cifras", cifras);
		
		return "listacifras";
	}
}
