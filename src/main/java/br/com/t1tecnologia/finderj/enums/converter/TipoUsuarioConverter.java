/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.enums.converter;

import br.com.t1tecnologia.finderj.enums.TipoUsuarioEnum;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexandre
 */
public class TipoUsuarioConverter {

    public TipoUsuarioConverter() {
    }

    public Map<String, String> getOptions() {
        Map<String, String> mapUsuario = new HashMap<>();
        for (TipoUsuarioEnum tipoUsuario : TipoUsuarioEnum.values()) {
            mapUsuario.put(tipoUsuario.getDescricao(), tipoUsuario.name());
        }

        return mapUsuario;
    }

}
