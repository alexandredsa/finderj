package br.com.t1tecnologia.finderj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.t1tecnologia.finderj.model.Profissional;
import br.com.t1tecnologia.finderj.model.Usuario;
@Repository
public interface ProfissionalRepository extends CrudRepository<Profissional, Long> {
	public Profissional findByProfUsuario(Usuario profUsuario);
}
