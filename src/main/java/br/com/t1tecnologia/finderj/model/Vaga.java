/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alexandre
 */
@Entity
public class Vaga implements Serializable{

    @Id
    @Column(name = "vaga_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "vaga_nome", length = 50, nullable = false)
    private String vagaNome;
    @Column(name = "vaga_salario", precision = 10, scale = 2)
    private Float vagaSalario;
    @Column(name = "vaga_descricao", length = 300, nullable = false)
    private String vagaDescricao;
    @Column(name = "vaga_dt_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vagaDtInicio;
    @Column(name = "vaga_dt_termino")
    @Temporal(TemporalType.DATE)
    private Date vagaDtTermino;
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="vaga_carg_id")
    private Cargo vagaCargo;

    public Cargo getVagaCargo() {
        return vagaCargo;
    }

    public void setVagaCargo(Cargo vagaCargo) {
        this.vagaCargo = vagaCargo;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getVagaNome() {
        return vagaNome;
    }

    public void setVagaNome(String vagaNome) {
        this.vagaNome = vagaNome;
    }

    public Float getVagaSalario() {
        return vagaSalario;
    }

    public void setVagaSalario(Float vagaSalario) {
        this.vagaSalario = vagaSalario;
    }

    public String getVagaDescricao() {
        return vagaDescricao;
    }

    public void setVagaDescricao(String vagaDescricao) {
        this.vagaDescricao = vagaDescricao;
    }

    public Date getVagaDtInicio() {
        return vagaDtInicio;
    }

    public void setVagaDtInicio(Date vagaDtInicio) {
        this.vagaDtInicio = vagaDtInicio;
    }

    public Date getVagaDtTermino() {
        return vagaDtTermino;
    }

    public void setVagaDtTermino(Date vagaDtTermino) {
        this.vagaDtTermino = vagaDtTermino;
    }

  
}
