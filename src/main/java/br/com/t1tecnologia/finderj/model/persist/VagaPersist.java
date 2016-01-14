package br.com.t1tecnologia.finderj.model.persist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Vaga;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;

@Component
public class VagaPersist {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private EmpresaRepository empresaRepository;

	public Object salvar(Vaga vaga) {
		Empresa empresa = sessionService.getEmpresaUsuarioSession();

		if (empresa != null) {
			empresa.addVaga(vaga);
			return empresaRepository.save(empresa);
		}

		return null;

	}

}
