package br.com.t1tecnologia.finderj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.t1tecnologia.finderj.enums.converter.EstadoCivilConverter;
import br.com.t1tecnologia.finderj.enums.converter.EstadoConverter;
import br.com.t1tecnologia.finderj.enums.converter.GrauEscolaridadeConverter;
import br.com.t1tecnologia.finderj.facade.ProfissionalFacade;
import br.com.t1tecnologia.finderj.model.Profissional;
import br.com.t1tecnologia.finderj.service.SessionService;

@Controller
@RequestMapping("/profissional")
public class ProfissionalController {

	@Autowired
	private ProfissionalFacade profissionalFacade;

	@Autowired
	private SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		Profissional profissional = sessionService.getProfissionalUsuarioSession();

		ModelAndView MvHome = new ModelAndView("profissional/cadastro");
		MvHome.addObject("estados", new EstadoConverter().getOptions());
		MvHome.addObject("estadoCivil", new EstadoCivilConverter().getOptions());
		MvHome.addObject("grausEscolaridade", new GrauEscolaridadeConverter().getOptions());
		if (profissional != null) {
			MvHome.addObject("profissional", profissional);
			MvHome.setViewName("profissional/editar");
		} else
			MvHome.setViewName("profissional/cadastro");

		return MvHome;
	}

	@RequestMapping(value = { "/cadastrar", "/editar" }, method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Profissional profissional, @RequestParam("profCargoNome") String[] profCargoNome,
			RedirectAttributes redir) {
		try {
			profissionalFacade.salvar(profissional, profCargoNome);
			redir.addFlashAttribute("sucesso", "Dados Atualizados com Sucesso!");
		} catch (Exception ex) {
			redir.addFlashAttribute("erro", "Erro ao atualizar dados de cadastro");
		}
		return new ModelAndView("redirect:/profissional");
	}

}
