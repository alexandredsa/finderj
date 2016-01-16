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
public class Experiencia implements Serializable {

	private static final long serialVersionUID = 1434504106172656837L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expr_id")
	private Long ID;
	@Column(name = "expr_nome", length = 50)
	private String exprNome;
	@Column(name = "expr_descricao", length = 200)
	private String exprDescricao;
	@Column(name = "expr_dt_inicio")
	@Temporal(TemporalType.DATE)
	private Date exprDtInicio;
	@Column(name = "expr_dt_termino")
	@Temporal(TemporalType.DATE)
	private Date exprDtTermino;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "expr_carg_id")
	private Cargo exprCargo;

	public Cargo getExprCargo() {
		return exprCargo;
	}

	public void setExprCargo(Cargo exprCargo) {
		this.exprCargo = exprCargo;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getExprNome() {
		return exprNome;
	}

	public void setExprNome(String exprNome) {
		this.exprNome = exprNome;
	}

	public String getExprDescricao() {
		return exprDescricao;
	}

	public void setExprDescricao(String exprDescricao) {
		this.exprDescricao = exprDescricao;
	}

	public Date getExprDtInicio() {
		return exprDtInicio;
	}

	public void setExprDtInicio(Date exprDtInicio) {
		this.exprDtInicio = exprDtInicio;
	}

	public Date getExprDtTermino() {
		return exprDtTermino;
	}

	public void setExprDtTermino(Date exprDtTermino) {
		this.exprDtTermino = exprDtTermino;
	}

}
