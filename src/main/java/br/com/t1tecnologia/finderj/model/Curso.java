package br.com.t1tecnologia.finderj.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alexandre
 */
@Entity
public class Curso implements Serializable {

    @Id
    @Column(name = "curs_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "curs_nome", length = 45, nullable = false)
    private String cursNome;
    @Column(name = "curs_instituicao", length = 50, nullable = false)
    private String cursInstituicao;
    @Temporal(TemporalType.DATE)
    @Column(name = "curs_dt_inicio", nullable = false)
    private Date cursDtInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "curs_dt_termino")
    private Date cursDtTermino;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCursNome() {
        return cursNome;
    }

    public void setCursNome(String cursNome) {
        this.cursNome = cursNome;
    }

    public String getCursInstituicao() {
        return cursInstituicao;
    }

    public void setCursInstituicao(String cursInstituicao) {
        this.cursInstituicao = cursInstituicao;
    }

    public Date getCursDtInicio() {
        return cursDtInicio;
    }

    public void setCursDtInicio(Date cursDtInicio) {
        this.cursDtInicio = cursDtInicio;
    }

    public Date getCursDtTermino() {
        return cursDtTermino;
    }

    public void setCursDtTermino(Date cursDtTermino) {
        this.cursDtTermino = cursDtTermino;
    }

}
