package br.com.t1tecnologia.finderj.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import br.com.t1tecnologia.finderj.enums.FileSaverPath;
import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;
import br.com.t1tecnologia.finderj.util.FileSaver;

@Component
public class EmpresaFacade {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private SessionService sessionService;

	private void inserir(MultipartFile emprUrlLogo, Empresa empresa, HttpServletRequest request) throws Exception {
		Usuario usuario = sessionService.getUsuarioSession();
		empresa.setEmprUsuario(usuario);
		salvarLogoEmpresa(emprUrlLogo, empresa, request);
		empresaRepository.save(empresa);
	}

	private void atualizar(MultipartFile emprUrlLogo, Empresa empresa, HttpServletRequest request) throws Exception {
		Usuario usuario = sessionService.getUsuarioSession();
		empresa.setEmprUsuario(usuario);
		salvarLogoEmpresa(emprUrlLogo, empresa, request);
		empresaRepository.save(empresa);
	}

	public void salvar(MultipartFile emprUrlLogo, Empresa empresa, HttpServletRequest request) throws Exception {
		Empresa empresaExistente = sessionService.getEmpresaUsuarioSession();
		if (empresaExistente != null) {
			empresa.setID(empresaExistente.getID());
			empresa.setEmprUrlLogo(empresaExistente.getEmprUrlLogo());
			empresa.setEmprVaga(empresaExistente.getEmprVaga());
			atualizar(emprUrlLogo, empresa, request);
		} else
			inserir(emprUrlLogo, empresa, request);
	}

	private void salvarLogoEmpresa(MultipartFile logo, Empresa empresa, HttpServletRequest request) throws Exception {
		if (!isValidLogo(logo))
			return;

		String pathUrl = FileSaver.saveFile(logo, empresa.getEmprNome().concat(".png"), FileSaverPath.PATH_IMAGES_LOGO,
				request);
		empresa.setEmprUrlLogo(pathUrl);
	}

	private boolean isValidLogo(MultipartFile logo) {
		return logo.getOriginalFilename().length() > 0;
	}
}
