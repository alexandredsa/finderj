/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.t1tecnologia.finderj.repository;

import br.com.t1tecnologia.finderj.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alexandre
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{


    public Usuario findByUsuaLoginAndUsuaSenhaAndUsuaAtivoTrue(String usuario, String senha);
    
    public Usuario findByUsuaLogin(String usuario);
    
}
