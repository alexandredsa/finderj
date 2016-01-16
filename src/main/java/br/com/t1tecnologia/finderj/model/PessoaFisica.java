package br.com.t1tecnologia.finderj.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "Pessoa_Fisica")
public class PessoaFisica implements Serializable {

	private static final long serialVersionUID = 8406346326511465046L;

	@Id
	@Column(name = "pfis_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	@Column(name = "pfis_nome", length = 30)
	private String pfisNome;
	@Column(name = "pfis_telefone", length = 15)
	private String pfisTelefone;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pfis_vaga_id")
	private List<Vaga> pfisVaga = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pfis_usua_id", unique = true)
	private Usuario pfisUsuario;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getPfisNome() {
		return pfisNome;
	}

	public void setPfisNome(String pfisNome) {
		this.pfisNome = pfisNome;
	}

	public String getPfisTelefone() {
		return pfisTelefone;
	}

	public void setPfisTelefone(String pfisTelefone) {
		this.pfisTelefone = pfisTelefone;
	}

	public List<Vaga> getPfisVaga() {
		return pfisVaga;
	}

	public void setPfisVaga(List<Vaga> pfisVaga) {
		this.pfisVaga = pfisVaga;
	}

	public Usuario getPfisUsuario() {
		return pfisUsuario;
	}

	public void setPfisUsuario(Usuario pfisUsuario) {
		this.pfisUsuario = pfisUsuario;
	}

}
