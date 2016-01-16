package br.com.t1tecnologia.finderj.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.t1tecnologia.finderj.enums.EstadoCivilEnum;
import br.com.t1tecnologia.finderj.enums.EstadoEnum;
import br.com.t1tecnologia.finderj.enums.GrauEscolaridadeEnum;

/**
 *
 * @author alexandre
 */
@Entity
public class Profissional implements Serializable {

	private static final long serialVersionUID = 625973071049811420L;

	@Id
	@Column(name = "prof_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	@Column(name = "prof__nome", length = 50, nullable = false)
	private String profNome;
	@Column(name = "prof_cep", length = 20, nullable = false)
	private String profCep;
	@Column(name = "prof_rua", length = 40)
	private String profRua;
	@Column(name = "prof_bairro", length = 40)
	private String profBairro;
	@Column(name = "prof_cidade", length = 30)
	private String profCidade;
	@Enumerated(EnumType.STRING)
	@Column(name = "prof_estado", length = 2)
	private EstadoEnum profEstado;
	@Column(name = "prof_numero_residencia", length = 8, nullable = false)
	private String profNumeroResidencia;
	@Column(name = "prof_complemento_residencia", length = 50)
	private String profComplementoResidencia;
	@Column(name = "prof_telefone", length = 15)
	private String profTelefone;
	@Column(name = "prof_celular", length = 15)
	private String profCelular;
	@Column(name = "prof_cpf", length = 14, nullable = false)
	private String profCpf;
	@Column(name = "prof_sexo", nullable = false, length = 1)
	private String profSexo;
	@Enumerated(EnumType.STRING)
	@Column(name = "prof_estado_civil", nullable = false, length = 20)
	private EstadoCivilEnum profEstadoCivil;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "prof_dt_nascimento", nullable = false)
	private Date profDtNascimento;
	@Enumerated(EnumType.STRING)
	@Column(name = "prof_grau_escolaridade", nullable = false, length = 20)
	private GrauEscolaridadeEnum profGrauEscolaridade;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Profissional_Curso", joinColumns = @JoinColumn(name = "prof_id") , inverseJoinColumns = @JoinColumn(name = "curs_id") )
	private List<Curso> profCurso = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prof_usua_id", unique = true)
	private Usuario profUsuario;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Profissional_Cargo", joinColumns = @JoinColumn(name = "prof_id") , inverseJoinColumns = @JoinColumn(name = "carg_id") )
	private List<Cargo> profCargo = new ArrayList<>();
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Profissional_Experiencia", joinColumns = @JoinColumn(name = "prof_id") , inverseJoinColumns = @JoinColumn(name = "expr_id") )
	private List<Experiencia> profExperiencia = new ArrayList<>();

	public String getProfBairro() {
		return profBairro;
	}

	public void setProfBairro(String profBairro) {
		this.profBairro = profBairro;
	}

	public String getProfCidade() {
		return profCidade;
	}

	public void setProfCidade(String profCidade) {
		this.profCidade = profCidade;
	}

	public EstadoEnum getProfEstado() {
		return profEstado;
	}

	public void setProfEstado(EstadoEnum profEstado) {
		this.profEstado = profEstado;
	}

	public List<Experiencia> getProfExperiencia() {
		return profExperiencia;
	}

	public void setProfExperiencia(List<Experiencia> profExperiencia) {
		this.profExperiencia = profExperiencia;
	}

	public Usuario getProfUsuario() {
		return profUsuario;
	}

	public void setProfUsuario(Usuario profUsuario) {
		this.profUsuario = profUsuario;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getProfNome() {
		return profNome;
	}

	public void setProfNome(String profNome) {
		this.profNome = profNome;
	}

	public String getProfCep() {
		return profCep;
	}

	public void setProfCep(String profCep) {
		this.profCep = profCep;
	}

	public String getProfNumeroResidencia() {
		return profNumeroResidencia;
	}

	public void setProfNumeroResidencia(String profNumeroResidencia) {
		this.profNumeroResidencia = profNumeroResidencia;
	}

	public String getProfComplementoResidencia() {
		return profComplementoResidencia;
	}

	public void setProfComplementoResidencia(String profComplementoResidencia) {
		this.profComplementoResidencia = profComplementoResidencia;
	}

	public String getProfTelefone() {
		return profTelefone;
	}

	public void setProfTelefone(String profTelefone) {
		this.profTelefone = profTelefone;
	}

	public String getProfCelular() {
		return profCelular;
	}

	public void setProfCelular(String profCelular) {
		this.profCelular = profCelular;
	}

	public String getProfCpf() {
		return profCpf;
	}

	public void setProfCpf(String profCpf) {
		this.profCpf = profCpf;
	}

	public String getProfSexo() {
		return profSexo;
	}

	public void setProfSexo(String profSexo) {
		this.profSexo = profSexo;
	}

	public EstadoCivilEnum getProfEstadoCivil() {
		return profEstadoCivil;
	}

	public void setProfEstadoCivil(EstadoCivilEnum profEstadoCivil) {
		this.profEstadoCivil = profEstadoCivil;
	}

	public Date getProfDtNascimento() {
		return profDtNascimento;
	}

	public void setProfDtNascimento(Date profDtNascimento) {
		this.profDtNascimento = profDtNascimento;
	}

	public List<Curso> getProfCurso() {
		return profCurso;
	}

	public void setProfCurso(List<Curso> profCurso) {
		this.profCurso = profCurso;
	}

	public List<Cargo> getProfCargo() {
		return profCargo;
	}

	public void setProfCargo(List<Cargo> profCargo) {
		this.profCargo = profCargo;
	}

	public GrauEscolaridadeEnum getProfGrauEscolaridade() {
		return profGrauEscolaridade;
	}

	public void setProfGrauEscolaridade(GrauEscolaridadeEnum profGrauEscolaridade) {
		this.profGrauEscolaridade = profGrauEscolaridade;
	}

	public String getProfRua() {
		return profRua;
	}

	public void setProfRua(String profRua) {
		this.profRua = profRua;
	}
}
