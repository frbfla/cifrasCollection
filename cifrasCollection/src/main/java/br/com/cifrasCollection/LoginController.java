package br.com.cifrasCollection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cifrasCollection.model.Usuario;
import br.com.cifrasCollection.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value= "cadastrar",  method = RequestMethod.POST )
    public String cadastrar(@RequestParam("nome") String nome, @RequestParam("sobrenome") String sobrenome,
    		@RequestParam("email") String email, @RequestParam("senha") String senha, Model model) {
        
		Usuario usuario = new Usuario();
		usuario.setNome(nome + " " + sobrenome);
		usuario.setLogin(email);
		usuario.setSenha(senha);
		
		Usuario cadastrado = this.service.salvar(usuario);
		
		if (cadastrado.getId() != null) {
			model.addAttribute("mensagemCadastro", "Usuario cadastrado com sucesso");
        } else {
        	model.addAttribute("mensagemCadastro", "Erro ao cadastrar, verifique as informações");
        }
		
		model.addAttribute("usuarioLogado", cadastrado);
		 
		return "login";
    }
	
	@RequestMapping(value= "logar",  method = RequestMethod.POST  )
    public String logar(@RequestParam("login") String login, @RequestParam("senha") String senha, Model model) {
		List<Usuario> usuarios = this.service.obterUsuario(login, senha);
		
        if(usuarios != null && usuarios.size() == 1) {
        	model.addAttribute("usuarioLogado", usuarios.get(0));
            return "index";
        } 
        
        model.addAttribute("mensagemLogin", "Login ou senha inválidos");
        return "login";
    }
}
