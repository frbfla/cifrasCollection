package br.com.cifrasCollection;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "pesquisarCifra", method = RequestMethod.POST )
	public String pesquisar(@RequestParam("filtro") String filtro, Model model) {
		
		List<Cifra> cifras = null;
		Iterable<Cifra> listaCifrasCompleta = null;
		
		if (filtro != null && !filtro.equals("")) {
			cifras = this.service.obterCifrasFiltro(filtro);	
		} else {
			listaCifrasCompleta = this.service.obterTodos();
		}	
		
		
		if (cifras != null && cifras.size() > 0) {
			model.addAttribute("cifras", cifras);
		} else {
			model.addAttribute("cifras", listaCifrasCompleta);
		}		
		
		return "pesquisarcifras";
		
	}
	
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
	
	@RequestMapping("/visualizarCifra/{id}")
	public ResponseEntity<byte[]> visualizarCifra(@PathVariable("id") Long id) {
		Cifra cifra = this.service.obterCifraPorId(Long.valueOf(id));
		
		HttpHeaders headers = new HttpHeaders();

	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "pdf1.pdf";

	    headers.add("content-disposition", "inline;filename=" + filename);
	  
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(cifra.getFotoCifra(), headers, HttpStatus.OK);
	    return response;
	}
}
