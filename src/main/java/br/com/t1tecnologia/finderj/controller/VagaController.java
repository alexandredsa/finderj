package br.com.t1tecnologia.finderj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.t1tecnologia.finderj.facade.VagaFacade;
import br.com.t1tecnologia.finderj.model.Vaga;
import br.com.t1tecnologia.finderj.repository.VagaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;

@Controller
@RequestMapping("/vagas")
public class VagaController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private VagaRepository vagaRepository;

	@Autowired
	private VagaFacade vagaFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView consulta() {
		ModelAndView mvVaga = new ModelAndView("vaga/consulta");
		mvVaga.addObject("vagas", vagaFacade.getVagas());
		return mvVaga;
	}

	@RequestMapping(value = "nova", method = RequestMethod.GET)
	public ModelAndView pageCadastro() {
		return new ModelAndView("vaga/cadastro");
	}

	@RequestMapping(value = "editar/{idVaga}", method = RequestMethod.GET)
	public ModelAndView pageEditar(@PathVariable Long idVaga) {
		ModelAndView mvVaga = new ModelAndView("vaga/editar");
		Vaga vaga = vagaRepository.findOne(idVaga);
		mvVaga.addObject("vaga", vaga);
		return mvVaga;
	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Vaga vaga) {
		vaga.setVagaDtInicio(new Date());
		vagaFacade.salvar(vaga);
		return new ModelAndView("redirect:/vagas");
	}

	@RequestMapping(value = "cadastrar/{id}", method = RequestMethod.POST)
	public ModelAndView cadastrar(Vaga vaga, @PathVariable Long id) {
		Vaga vagaExistente = vagaRepository.findOne(id);
		vaga.setID(id);
		vaga.setVagaDtInicio(vagaExistente.getVagaDtInicio());
		vagaRepository.save(vaga);
		return new ModelAndView("redirect:/vagas");
	}

	@RequestMapping(value = "excluir/{id}", method = RequestMethod.GET)
	public ModelAndView deletar(Vaga vaga, @PathVariable Long id) {
		vaga.setID(id);
		vagaRepository.delete(vaga);
		return new ModelAndView("redirect:/vagas");
	}

}
