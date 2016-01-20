package br.com.t1tecnologia.finderj.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.t1tecnologia.finderj.Boot;
import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.vo.VagaVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Boot.class)
public class EmpresaRepositoryTest {
	@Autowired
	private EmpresaRepository empresaRepository;

	@Test
	public void deveRetornarEmpresaComVagas() {
		List<Empresa> empresas = empresaRepository.findAllFetchEagerVagasAtivas();
		ArrayList<VagaVO> vagas = new ArrayList<>();

		for (Empresa e : empresas) {
			vagas.add(new VagaVO(e, e.getEmprVaga().get(0)));
		}

		Assert.assertTrue(vagas.size() > 0);
	}

}
