/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.enums.converter;

import br.com.t1tecnologia.finderj.enums.EstadoEnum;
import java.util.Map;
import org.apache.commons.lang3.EnumUtils;

/**
 *
 * @author alexandre
 */
public class EstadoConverter implements IEnumConverter{

    public EstadoConverter() {
    }

    @Override
    public Map<String, ?> getOptions() {
        return EnumUtils.getEnumMap(EstadoEnum.class);
    }
}
