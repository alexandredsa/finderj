package br.com.t1tecnologia.finderj.vo;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Vaga;

public class VagaVO {
	private Long idVaga;
	private String nomeEmpresa;
	private String bairro;
	private String cidade;
	private String estado;
	private String urlLogo;
	private String titulo;
	private String descricao;
	private Float salario;

	public VagaVO() {
	}

	public VagaVO(Empresa empresa, Vaga vaga) {
		constroiVagaVO(empresa, vaga);
	}

	private void constroiVagaVO(Empresa empresa, Vaga vaga) {
		this.nomeEmpresa = empresa.getEmprNome();
		this.bairro = empresa.getEmprBairro();
		this.cidade = empresa.getEmprCidade();
		this.estado = empresa.getEmprEstado().toString();
		this.urlLogo = empresa.getEmprUrlLogo();
		this.titulo = vaga.getVagaNome();
		this.descricao = vaga.getVagaDescricao();
		this.salario = vaga.getVagaSalario();
		this.idVaga = vaga.getID();
	}

	public Long getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(Long idVaga) {
		this.idVaga = idVaga;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

}
