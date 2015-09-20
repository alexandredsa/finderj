/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.model;

import br.com.t1tecnologia.finderj.enums.TipoUsuarioEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author alexandre
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @Column(name = "usua_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column(name = "usua_login", length = 45, nullable = false, unique = true)
    private String usuaLogin;
    @Column(name = "usua_senha", length = 32, nullable = false)
    private String usuaSenha;
    @Column(name = "usua_admin")
    @Type(type="boolean")
    private boolean usuaAdmin;

    @Enumerated(EnumType.STRING)
    @Column(name = "usua_tipo_usuario")
    private TipoUsuarioEnum tipoUsuario;

    public Usuario() {
    }

    public Usuario(String usuaLogin, String usuaSenha) {
        this.usuaLogin = usuaLogin;
        this.usuaSenha = usuaSenha;
    }

    public Usuario(String usuaLogin, String usuaSenha, TipoUsuarioEnum tipoUsuarioEnum) {
        this.usuaLogin = usuaLogin;
        this.usuaSenha = usuaSenha;
        this.tipoUsuario = tipoUsuarioEnum;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuaLogin() {
        return usuaLogin;
    }

    public void setUsuaLogin(String usuaLogin) {
        this.usuaLogin = usuaLogin;
    }

    public boolean isUsuaAdmin() {
        return usuaAdmin;
    }

    public void setUsuaAdmin(boolean usuaAdmin) {
        this.usuaAdmin = usuaAdmin;
    }

    public String getUsuaSenha() {
        return usuaSenha;
    }

    public void setUsuaSenha(String usuaSenha) {
        this.usuaSenha = usuaSenha;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}
