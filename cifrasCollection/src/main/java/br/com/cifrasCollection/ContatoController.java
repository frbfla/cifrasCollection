package br.com.cifrasCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cifrasCollection.model.Mensagem;
import br.com.cifrasCollection.service.MensagemService;

@Controller
public class ContatoController {

	@Autowired
	private MensagemService service;
		
	@RequestMapping(value= "cadastrarMensagem",  method = RequestMethod.POST )
    public String cadastrarMensagem(@RequestParam("nome") String nome,	@RequestParam("email") String email, @RequestParam("mensagem") String mensagem, Model model) {
        
		Mensagem msg = new Mensagem();
		msg.setNome(nome);
		msg.setEmail(email);
		msg.setMensagem(mensagem);
		
		Mensagem msgSalva = this.service.salvar(msg);
		
		if (msgSalva.getId() != null) {
			model.addAttribute("mensagemCadastro", "Mensagem enviada com sucesso");
        } else {
        	model.addAttribute("mensagemCadastro", "Erro ao enviar, verifique as informações");
        }
		 
		return "contato";
    }

}
