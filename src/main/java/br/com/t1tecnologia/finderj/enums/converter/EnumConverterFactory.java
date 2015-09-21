/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.enums.converter;

import java.util.Map;

/**
 *
 * @author alexandre
 */
public class EnumConverterFactory {

    public static Map<String, ?> getEnumOptions(String enumKey) {
       if(enumKey.equals("enum_tipo_usuario")){
          return new TipoUsuarioConverter().getOptions();
       }
       
       if(enumKey.equals("enum_estado")){
           return new EstadoConverter().getOptions();
       }
       
       return null;
    }

}
