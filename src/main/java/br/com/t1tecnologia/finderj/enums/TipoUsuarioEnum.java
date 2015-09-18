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
public enum TipoUsuarioEnum {

    PESSOA_JURIDICA("Pessoa Jurídica"), PESSOA_FISICA("Pessoa Física");

    private final String descricao;

    private TipoUsuarioEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
