package br.com.t1tecnologia.finderj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.t1tecnologia.finderj.enums.FileSaverPath;
import br.com.t1tecnologia.finderj.enums.converter.EstadoConverter;
import br.com.t1tecnologia.finderj.facade.EmpresaFacade;
import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;
import br.com.t1tecnologia.finderj.util.ConsoleLog;
import br.com.t1tecnologia.finderj.util.FileSaver;

/**
 * 
 * @author alexandre
 */
@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private SessionService sessionService;

	@Autowired
	private EmpresaFacade empresaFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		Empresa empresa = sessionService.getEmpresaUsuarioSession();

		ModelAndView MvHome = new ModelAndView("empresa/editar");
		MvHome.addObject("estados", new EstadoConverter().getOptions());
		if (empresa != null) {
			MvHome.addObject("empresa", empresa);
			MvHome.setViewName("empresa/editar");
		} else {
			MvHome.setViewName("empresa/cadastro");
		}

		return MvHome;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = { "/cadastrar" })
	public ModelAndView salvar(@Valid Empresa empresa, HttpServletRequest request,
			@RequestParam("urlLogo") MultipartFile emprUrlLogo, RedirectAttributes redir) throws Exception {
		try {
			if (isEmpresaNomeDisponivel(empresa.getEmprNome())) {
				empresaFacade.salvar(emprUrlLogo, empresa, request);
				redir.addFlashAttribute("sucesso", "Dados da Empresa Atualizados com Sucesso!");
			} else
				redir.addFlashAttribute("erro", "Nome de Empresa não disponível");

		} catch (Exception ex) {
			redir.addFlashAttribute("erro", "Erro ao salvar Dados de Empresa");
		}

		return new ModelAndView("redirect:/empresa");

	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/editar")
	public ModelAndView editar(@RequestParam("urlLogo") MultipartFile emprUrlLogo, @Valid Empresa empresa,
			HttpServletRequest request, RedirectAttributes redir) {
		try {

			Empresa empresaExistente = sessionService.getEmpresaUsuarioSession();

			if (empresaExistente != null) {
				empresaFacade.salvar(emprUrlLogo, empresa, request);
			} else
				redir.addFlashAttribute("erro", "Nome de Empresa não disponível");

		} catch (Exception ex) {
			ConsoleLog.writeString(ex.getMessage());
			redir.addFlashAttribute("erro", "Erro ao salvar Dados de Empresa");
		}

		return new ModelAndView("redirect:/empresa");
	}

	private boolean isEmpresaNomeDisponivel(String nomeEmpresa) {
		return empresaRepository.findByEmprNome(nomeEmpresa) == null;
	}

}
