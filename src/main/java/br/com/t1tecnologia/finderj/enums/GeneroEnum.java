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
