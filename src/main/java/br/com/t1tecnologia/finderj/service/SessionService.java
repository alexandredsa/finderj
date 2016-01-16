package br.com.t1tecnologia.finderj.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.t1tecnologia.finderj.enums.SessionEnum;
import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Profissional;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.repository.ProfissionalRepository;
import br.com.t1tecnologia.finderj.repository.UsuarioRepository;
import br.com.t1tecnologia.finderj.util.ConsoleLog;

/**
 *
 * @author alexandre Classe criada para recuperar dados do Session que sejam
 *         relevantes para os controllers.
 *
 */
@Service("serviceSession")
public class SessionService {

	private UsuarioRepository usuarioRepository;
	private EmpresaRepository empresaRepository;
	private ProfissionalRepository profissionalRepository;
	private HttpSession session;

	@Autowired
	public SessionService(UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository,
			ProfissionalRepository profissionalRepository, HttpSession session) {
		this.usuarioRepository = usuarioRepository;
		this.empresaRepository = empresaRepository;
		this.profissionalRepository = profissionalRepository;
		this.session = session;
	}

	public String getUsuarioName() {
		return (String) session.getAttribute(SessionEnum.USUARIO.toString());
	}

	public Usuario getUsuarioSession() {
		try {
			String nomeUsuario = getUsuarioName();
			return usuarioRepository.findByUsuaLogin(nomeUsuario);
		} catch (Exception ex) {
			ConsoleLog.writeString(ex.getMessage());
		}

		return null;

	}

	public Empresa getEmpresaUsuarioSession() {
		try {
			return empresaRepository.findByEmprUsuario(getUsuarioSession());
		} catch (Exception ex) {
			ConsoleLog.writeString(ex.getMessage());
		}

		return null;

	}

	public Profissional getProfissionalUsuarioSession() {
		Profissional p = null;
		try {
			p = profissionalRepository.findByProfUsuario(getUsuarioSession());
		} catch (Exception ex) {
			ConsoleLog.writeString(ex.getMessage());
		}
		return p;
	}

}
