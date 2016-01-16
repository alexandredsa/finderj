package br.com.t1tecnologia.finderj.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.t1tecnologia.finderj.model.Profissional;
import br.com.t1tecnologia.finderj.model.Usuario;

public interface ProfissionalRepository extends CrudRepository<Profissional, Long> {
	public Profissional findByProfUsuario(Usuario profUsuario);
}
