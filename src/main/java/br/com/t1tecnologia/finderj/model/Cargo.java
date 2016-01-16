package br.com.t1tecnologia.finderj.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alexandre
 */
@Entity
public class Cargo implements Serializable {

	private static final long serialVersionUID = 3551918196296318971L;
	
	@Id
    @Column(name = "carg_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "carg_nome", length = 30, nullable = false, unique = true)
    private String cargNome;
    
    public Cargo(){}
    

    public Cargo(String cargNome) {
		this.cargNome = cargNome;
	}

	public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCargNome() {
        return cargNome;
    }

    public void setCargNome(String cargNome) {
        this.cargNome = cargNome;
    }

}
