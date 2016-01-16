package br.com.t1tecnologia.finderj.enums.converter;

import java.util.HashMap;
import java.util.Map;

import br.com.t1tecnologia.finderj.enums.EstadoCivilEnum;

public class EstadoCivilConverter implements IEnumConverter {

	@Override
	public Map<String, String> getOptions() {
		Map<String, String> mapEstadoCivil = new HashMap<>();
		for (EstadoCivilEnum estadoCivil : EstadoCivilEnum.values()) {
			mapEstadoCivil.put(estadoCivil.getDescricao(), estadoCivil.name());
		}

		return mapEstadoCivil;
	}

}
