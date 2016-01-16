package br.com.t1tecnologia.finderj.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Vaga;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;

@Component
public class VagaFacade {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private EmpresaRepository empresaRepository;

	public void salvar(Vaga vaga) {
		Empresa empresa = sessionService.getEmpresaUsuarioSession();

		if (empresa != null) {
			empresa.addVaga(vaga);
			empresaRepository.save(empresa);
		}
	}

}
