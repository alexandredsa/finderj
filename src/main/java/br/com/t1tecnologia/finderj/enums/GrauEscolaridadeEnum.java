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
