package br.com.t1tecnologia.finderj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.t1tecnologia.finderj.model.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Long> {

	public Cargo findByCargNome(String cargNome);

}
