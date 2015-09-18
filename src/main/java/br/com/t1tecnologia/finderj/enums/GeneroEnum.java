/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.enums;

/**
 *
 * @author alexandre
 */
public enum GeneroEnum {
    M("Masculino"), F("Feminino");
    
    private final String genero;
    
    private GeneroEnum(String genero){
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
    
    
    
}
