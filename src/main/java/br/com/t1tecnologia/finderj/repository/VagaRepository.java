package br.com.t1tecnologia.finderj.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.t1tecnologia.finderj.model.Vaga;

public interface VagaRepository extends CrudRepository<Vaga, Long>, VagaRepositoryCustom{
	
	public List<Vaga> findByVagasAtivas();

}
