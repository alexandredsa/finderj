package br.com.t1tecnologia.finderj.repository;

import java.util.List;

import br.com.t1tecnologia.finderj.model.Vaga;

public interface VagaRepositoryCustom {
	public List<Vaga> findByVagasAtivas();
}
