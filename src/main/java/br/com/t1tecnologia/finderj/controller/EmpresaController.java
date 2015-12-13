package br.com.t1tecnologia.finderj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.t1tecnologia.finderj.enums.FileSaverPath;
import br.com.t1tecnologia.finderj.enums.converter.EstadoConverter;
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
	EmpresaRepository empresaRepository;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		Empresa empresa = sessionService.getEmpresaUsuarioSession();

		ModelAndView MvHome = new ModelAndView("empresa/editar");
		// MvHome.addObject("nomeUsuario", sessionService.getUsuarioName());
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
	public String salvar(@Valid Empresa empresa, HttpServletRequest request,
			@RequestParam("urlLogo") MultipartFile emprUrlLogo) throws Exception {
		Usuario usuario = sessionService.getUsuarioSession();
		empresa.setEmprUsuario(usuario);

		if (isEmpresaNomeDisponivel(empresa.getEmprNome())) {
			salvarLogoEmpresa(emprUrlLogo, empresa, request);
			empresaRepository.save(empresa);
			return "true";
		}

		return "Nome de empresa já cadastrado.";

	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/editar")
	public String editar(@RequestParam("urlLogo") MultipartFile emprUrlLogo,
			@Valid Empresa empresa, HttpServletRequest request) {
		try {
			Usuario usuario = sessionService.getUsuarioSession();
			Empresa empresaExistente = sessionService
					.getEmpresaUsuarioSession();

			if (empresaExistente != null) {
				empresa.setEmprUsuario(usuario);
				empresa.setID(empresaExistente.getID());
				empresa.setEmprUrlLogo(empresaExistente.getEmprUrlLogo());
				salvarLogoEmpresa(emprUrlLogo, empresa, request);
				empresaRepository.save(empresa);
				return "true";
			}

		} catch (Exception ex) {
			ConsoleLog.writeString(ex.getMessage());
		}

		return "false";
	}

	private void salvarLogoEmpresa(MultipartFile logo, Empresa empresa,
			HttpServletRequest request) throws Exception {
		if (!isValidLogo(logo))
			return;

		String pathUrl = FileSaver.saveFile(logo,
				empresa.getEmprNome().concat(".png"),
				FileSaverPath.PATH_IMAGES_LOGO, request);
		empresa.setEmprUrlLogo(pathUrl);
	}

	private boolean isEmpresaNomeDisponivel(String nomeEmpresa) {
		return empresaRepository.findByEmprNome(nomeEmpresa) == null;
	}

	private boolean isValidLogo(MultipartFile logo) {
		return logo.getOriginalFilename().length() > 0;
	}

}
