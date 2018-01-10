package br.com.cifrasCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.cifrasCollection.enumeration.TomMusica;
import br.com.cifrasCollection.model.Cifra;
import br.com.cifrasCollection.service.CifraService;

@Controller
public class CifrasController {

	@Autowired
	private CifraService service;

	
	@RequestMapping(value = "cadastrarCifra", method = RequestMethod.POST )
	public String salvar(@RequestParam("nome") String nome, @RequestParam("tom")String tom, 
			@RequestParam("cantor") String cantor, @RequestParam("linkYouTube") String linkYouTube,
			@RequestParam("arquivo") MultipartFile fotoDaCifra, Model model){
				
		try {
			Cifra novaCifra = new Cifra();
			novaCifra.setNome(nome);
			TomMusica tomMusica = TomMusica.getEnumByDescricao(tom);		
			
			if (tomMusica != null) {
				novaCifra.setTom(tomMusica);
			}
			
			novaCifra.setCantor(cantor);
			novaCifra.setLinkYoutube(linkYouTube);
			novaCifra.setFotoCifra(fotoDaCifra.getBytes());
			
			Cifra cifraCadastrada = service.salvar(novaCifra);
			
			if (cifraCadastrada != null) {
				model.addAttribute("mensagemCadastro", "Cifra cadastrada com sucesso");
			} else {
				model.addAttribute("mensagemCadastro", "Erro ao cadastar a cifra, verifique os dados enviados");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		Iterable<Cifra> cifras = service.obterTodos();
		model.addAttribute("cifras", cifras);
		
		return "cadastrarcifras";
		
	}
}
