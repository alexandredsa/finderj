package br.com.t1tecnologia.finderj.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.t1tecnologia.finderj.model.Cargo;
import br.com.t1tecnologia.finderj.model.Profissional;
import br.com.t1tecnologia.finderj.model.Usuario;
import br.com.t1tecnologia.finderj.repository.CargoRepository;
import br.com.t1tecnologia.finderj.repository.ProfissionalRepository;
import br.com.t1tecnologia.finderj.service.SessionService;

@Component
public class ProfissionalFacade {
	@Autowired
	private ProfissionalRepository profissionalRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private SessionService sessionService;

	/**
	 * Verifica se profissional está cadastrado. Realiza tanto INSERT quanto
	 * UPDATE da entidade.
	 * 
	 * @param profissional
	 * @param nomeCargos
	 */
	public void salvar(Profissional profissional, String[] nomeCargos) {
		if (isProfissionalCadastrado())
			atualizar(profissional, nomeCargos);
		else
			inserir(profissional, nomeCargos);
	}

	private void atualizar(Profissional profissional, String[] nomeCargos) {
		Profissional profissionalExistente = sessionService.getProfissionalUsuarioSession();
		profissional.setProfCargo(criarCargos(nomeCargos));
		profissional.setID(profissionalExistente.getID());
		profissional.setProfUsuario(sessionService.getUsuarioSession());
		profissionalRepository.save(profissional);
	}

	private void inserir(Profissional profissional, String[] nomeCargos) {
		Usuario u = sessionService.getUsuarioSession();
		profissional.setProfUsuario(u);
		profissional.setProfCargo(criarCargos(nomeCargos));
		profissionalRepository.save(profissional);
	}

	private boolean isProfissionalCadastrado() {
		return profissionalRepository.findByProfUsuario(sessionService.getUsuarioSession()) != null;
	}

	/**
	 * Verifica se o Cargo já está cadastrado, e apenas devolve referência, caso
	 * contrário efetua o cadastro do mesmo no BD.
	 * 
	 * @param nomeCargos
	 * @return
	 */

	private List<Cargo> criarCargos(String[] nomeCargos) {
		ArrayList<Cargo> cargos = new ArrayList<>();

		for (String nomeCargo : nomeCargos) {
			if (nomeCargo.trim() == "")
				continue;

			Cargo c = cargoRepository.findByCargNome(nomeCargo);
			if (c == null)
				c = cargoRepository.save(new Cargo(nomeCargo));

			cargos.add(c);

		}

		return cargos;
	}

}
