package br.com.t1tecnologia.finderj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.t1tecnologia.finderj.repository.UsuarioRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView viewAdmin = new ModelAndView("admin/home");
		viewAdmin.addObject("usuarios", usuarioRepository.findAllByOrderByIDDesc());
		return viewAdmin;
	}
}
