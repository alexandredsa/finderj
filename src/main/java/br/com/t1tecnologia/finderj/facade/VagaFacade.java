package br.com.t1tecnologia.finderj.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Vaga;
import br.com.t1tecnologia.finderj.repository.EmpresaRepository;
import br.com.t1tecnologia.finderj.service.SessionService;
import br.com.t1tecnologia.finderj.vo.VagaVO;

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

	public List<VagaVO> getVagas() {
		if (sessionService.isPessoaJuridicaComEmpresa()) {
			return getVagasEmpresa();
		} else if (sessionService.isAdmin())
			return getAllVagas();

		throw new UnsupportedOperationException("Não implementado para este tipo de Usuário");
	}

	private List<VagaVO> getAllVagas() {
		List<Empresa> empresas = empresaRepository.findAllFetchEagerVagasAtivas();
		ArrayList<VagaVO> vagas = new ArrayList<>();

		for (Empresa e : empresas) {
			for (Vaga v : e.getEmprVaga())
				vagas.add(new VagaVO(e, v));
		}
		return vagas;
	}

	private List<VagaVO> getVagasEmpresa() {
		Empresa empresa = sessionService.getEmpresaUsuarioSession();
		ArrayList<VagaVO> vagas = new ArrayList<>();
		for (Vaga v : empresa.getEmprVaga()) {
			vagas.add(new VagaVO(empresa, v));
		}
		return vagas;
	}

}
