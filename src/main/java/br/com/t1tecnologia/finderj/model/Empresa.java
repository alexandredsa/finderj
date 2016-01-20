package br.com.t1tecnologia.finderj.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.t1tecnologia.finderj.enums.EstadoEnum;

/**
 *
 * @author alexandre
 */
@Entity 
public class Empresa implements Serializable {

	private static final long serialVersionUID = -2103148598887048661L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empr_id")
    private Long ID;
    @Column(name = "empr_nome", length = 40, nullable = false)
    private String emprNome;
    @Column(name = "empr_razao_social", length = 80, nullable = false)
    private String emprRazaoSocial;
    @Column(name = "empr_descricao", length = 300)
    private String emprDescricao;
    @Column(name = "empr_cnpj", length = 14, nullable = (false))
    private String emprCnpj;
    @Column(name = "empr_cep", length = 20, nullable = false)
    private String emprCep;
    @Column(name = "empr_bairro", length = 40)
    private String emprBairro;
    @Column(name = "empr_rua", length = 40)
    private String emprRua;
    @Column(name = "empr_cidade", length = 30)
    private String emprCidade;
    @Enumerated(EnumType.STRING)
    @Column(name = "empr_estado", length = 2)
    private EstadoEnum emprEstado;
    @Column(name = "empr_numero_residencia", length = 10, nullable = false)
    private String emprNumeroResidencia;
    @Column(name = "empr_complemento_residencia", length = 50)
    private String emprComplementoResidencia;
    @Column(name = "empr_nome_contato", nullable = false)
    private String emprNomeContato;
    @Column(name = "empr_url_logo", length = 90)
    private String emprUrlLogo;
    @Column(name = "empr_telefone", length = 15, nullable = false)
    private String emprTelefone;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "empr_vaga_id")
    private List<Vaga> emprVaga = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "empr_usua_id")    
    private Usuario emprUsuario;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getEmprNome() {
        return emprNome;
    }

    public void setEmprNome(String emprNome) {
        this.emprNome = emprNome;
    }

    public String getEmprRazaoSocial() {
        return emprRazaoSocial;
    }

    public void setEmprRazaoSocial(String emprRazaoSocial) {
        this.emprRazaoSocial = emprRazaoSocial;
    }

    public String getEmprDescricao() {
        return emprDescricao;
    }

    public void setEmprDescricao(String emprDescricao) {
        this.emprDescricao = emprDescricao;
    }

    public String getEmprCnpj() {
        return emprCnpj;
    }

    public void setEmprCnpj(String emprCnpj) {
        this.emprCnpj = emprCnpj;
    }

    public String getEmprCep() {
        return emprCep;
    }

    public void setEmprCep(String emprCep) {
        this.emprCep = emprCep;
    }

    public String getEmprBairro() {
        return emprBairro;
    }

    public void setEmprBairro(String emprBairro) {
        this.emprBairro = emprBairro;
    }

    public String getEmprRua() {
        return emprRua;
    }

    public void setEmprRua(String emprRua) {
        this.emprRua = emprRua;
    }

    public String getEmprCidade() {
        return emprCidade;
    }

    public void setEmprCidade(String emprCidade) {
        this.emprCidade = emprCidade;
    }

    public EstadoEnum getEmprEstado() {
        return emprEstado;
    }

    public void setEmprEstado(EstadoEnum emprEstado) {
        this.emprEstado = emprEstado;
    }

    public String getEmprNumeroResidencia() {
        return emprNumeroResidencia;
    }

    public void setEmprNumeroResidencia(String emprNumeroResidencia) {
        this.emprNumeroResidencia = emprNumeroResidencia;
    }

    public String getEmprComplementoResidencia() {
        return emprComplementoResidencia;
    }

    public void setEmprComplementoResidencia(String emprComplementoResidencia) {
        this.emprComplementoResidencia = emprComplementoResidencia;
    }

    public String getEmprNomeContato() {
        return emprNomeContato;
    }

    public void setEmprNomeContato(String emprNomeContato) {
        this.emprNomeContato = emprNomeContato;
    }

    public String getEmprUrlLogo() {
        return emprUrlLogo;
    }

    public void setEmprUrlLogo(String emprUrlLogo) {
        this.emprUrlLogo = emprUrlLogo;
    }

    public String getEmprTelefone() {
        return emprTelefone;
    }

    public void setEmprTelefone(String emprTelefone) {
        this.emprTelefone = emprTelefone;
    }
    
    public void addVaga(Vaga vaga){
    	if(this.emprVaga == null)
    		this.emprVaga = new ArrayList<>();
    	
    	this.emprVaga.add(vaga);
    }

    public List<Vaga> getEmprVaga() {
        return emprVaga;
    }

    public void setEmprVaga(List<Vaga> emprVaga) {
        this.emprVaga = emprVaga;
    }

    public Usuario getEmprUsuario() {
        return emprUsuario;
    }

    public void setEmprUsuario(Usuario emprUsuario) {
        this.emprUsuario = emprUsuario;
    }

}
