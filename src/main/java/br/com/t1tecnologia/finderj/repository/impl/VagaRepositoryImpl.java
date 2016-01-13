package br.com.t1tecnologia.finderj.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.t1tecnologia.finderj.model.Vaga;
import br.com.t1tecnologia.finderj.repository.VagaRepository;
import br.com.t1tecnologia.finderj.repository.VagaRepositoryCustom;



public class VagaRepositoryImpl implements VagaRepositoryCustom{
	
	@Autowired
	VagaRepository vagaRepository;
	
	@Override
	public List<Vaga> findByVagasAtivas() {
		//TODO
		return null;
	}

}
