package br.com.t1tecnologia.finderj.controller;

import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.enums.TipoUsuarioEnum;
import br.com.t1tecnologia.finderj.enums.converter.TipoUsuarioConverter;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.UsuarioRepository;
import br.com.t1tecnologia.finderj.service.SessionService;
import br.com.t1tecnologia.finderj.util.ConvertToMd5;

/**
 *
 * @author alexandre
 */
@Controller
@RequestMapping(value = { "/usuario", "/login" })
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("usuario/login");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mvCadastro = new ModelAndView("usuario/cadastro");
		mvCadastro.addObject("tipoUsuarios", new TipoUsuarioConverter().getOptions());
		return mvCadastro;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar")
	public ModelAndView cadastrar(Usuario u) throws Exception {
		try {
			if (isLoginDisponivel(u.getUsuaLogin())) {
				u.setUsuaSenha(ConvertToMd5.CriptografaSenha(u.getUsuaSenha()));
				u.setUsuaAdmin(false);
				u.setUsuaAtivo(true);
				usuarioRepository.save(u);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return new ModelAndView("redirect:/login");
	}

	@ResponseBody
	@RequestMapping(value = "/logar", method = RequestMethod.POST)
	public ModelAndView autenticar(Usuario usua, HttpSession session, HttpServletResponse response,
			RedirectAttributes redir) throws NoSuchAlgorithmException, LoginException {
		Usuario u = null;

		u = usuarioRepository.findByUsuaLoginAndUsuaSenhaAndUsuaAtivoTrue(usua.getUsuaLogin(),
				ConvertToMd5.CriptografaSenha(usua.getUsuaSenha()));

		if (u != null) {
			session.setAttribute(SessionEnum.USUARIO.name(), u.getUsuaLogin());
			session.setAttribute(SessionEnum.TIPO_USUARIO.name(), u.getUsuaTipoUsuario());
			session.setAttribute(SessionEnum.ADMIN.name(), u.isUsuaAdmin());

			if (u.getUsuaTipoUsuario().equals(TipoUsuarioEnum.PESSOA_JURIDICA)) {
				if (isEmpresaCadastrada())
					return new ModelAndView("redirect:/vagas");
				else
					return new ModelAndView("redirect:/empresa");
			}

			if (u.getUsuaTipoUsuario().equals(TipoUsuarioEnum.PESSOA_FISICA) && !u.isUsuaAdmin())
				return new ModelAndView("redirect:/profissional");
			
			if(u.isUsuaAdmin())
				return new ModelAndView("redirect:/admin");
		}

		if (isUsuarioInativo(usua))
			redir.addFlashAttribute("erro", MessageFormat.format("A conta {0} foi desativada.", usua.getUsuaLogin()));
		else
			redir.addFlashAttribute("erro", "Usuário e/ou senha inválido(s)");
		
		
		redir.addFlashAttribute("usuaLogin", usua.getUsuaLogin());

		return new ModelAndView("redirect:/login");
	}

	private boolean isUsuarioInativo(Usuario usua) throws NoSuchAlgorithmException {
		return usuarioRepository.findByUsuaLoginAndUsuaSenhaAndUsuaAtivoFalse(usua.getUsuaLogin(),
				ConvertToMd5.CriptografaSenha(usua.getUsuaSenha())) != null;
	}

	private boolean isEmpresaCadastrada() {
		return sessionService.getEmpresaUsuarioSession() != null;
	}

	private boolean isLoginDisponivel(String usuario) {
		return usuarioRepository.findByUsuaLogin(usuario) == null;
	}

}
