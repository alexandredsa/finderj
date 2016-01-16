package br.com.t1tecnologia.finderj.enums.converter;

import java.util.HashMap;
import java.util.Map;

import br.com.t1tecnologia.finderj.enums.GrauEscolaridadeEnum;

public class GrauEscolaridadeConverter implements IEnumConverter {

	@Override
	public Map<String, String> getOptions() {
		Map<String, String> mapGrauEscolaridade = new HashMap<>();
		for (GrauEscolaridadeEnum grauEscolaridade : GrauEscolaridadeEnum.values()) {
			mapGrauEscolaridade.put(grauEscolaridade.getDescricao(), grauEscolaridade.name());
		}

		return mapGrauEscolaridade;
	}

}
