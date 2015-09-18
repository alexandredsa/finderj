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
public enum GrauEscolaridadeEnum {

    ENSINO_FUNDAMENTAL("Ensino Fundamental"), ENSINO_MEDIO("Ensino Médio"), GRADUACAO("Ensino Superior");

    private final String descricao;

    private GrauEscolaridadeEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
