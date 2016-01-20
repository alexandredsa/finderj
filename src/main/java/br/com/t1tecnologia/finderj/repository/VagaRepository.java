package br.com.t1tecnologia.finderj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.t1tecnologia.finderj.model.Vaga;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Long> {

	public List<Vaga> findAllByVagaDtTerminoIsNullOrderByIDDesc();

}
