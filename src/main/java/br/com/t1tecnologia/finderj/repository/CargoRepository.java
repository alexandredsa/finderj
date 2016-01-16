package br.com.t1tecnologia.finderj.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.t1tecnologia.finderj.model.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Long> {

	public Cargo findByCargNome(String cargNome);

}
