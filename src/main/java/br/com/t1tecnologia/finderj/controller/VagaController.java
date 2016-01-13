package br.com.t1tecnologia.finderj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.repository.VagaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;

@Controller
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	SessionService sessionService;

	@Autowired
	VagaRepository vagaRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView consulta() {
		ModelAndView mvVaga = new ModelAndView("vaga/consulta");
		Empresa empresa = sessionService.getEmpresaUsuarioSession();

		if (empresa != null) {
			mvVaga.addObject("vagas", empresa.getEmprVaga());
			mvVaga.addObject("logo", empresa.getEmprUrlLogo());
		} else
			mvVaga.addObject("vagas", vagaRepository.findByVagasAtivas());

		return mvVaga;
	}

}
