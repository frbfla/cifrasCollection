package br.com.cifrasCollection;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cifrasCollection.model.Usuario;
import br.com.cifrasCollection.service.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping("loginForm")
    public String loginForm() {
        return "formulario-login";
    }
	
	@RequestMapping("efetuaLogin")
    public String efetuaLogin(@RequestParam("login") String login, @RequestParam("senha") String senha, HttpSession session) {
		List<Usuario> usuarios = this.service.obterUsuario(login, senha);
		
        if(usuarios != null) {
            session.setAttribute("usuarioLogado", usuarios.get(0));
            return "menu";
        }
        return "redirect:loginForm";
    }
}
