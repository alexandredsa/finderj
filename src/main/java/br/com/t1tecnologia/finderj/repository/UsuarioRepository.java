package br.com.t1tecnologia.finderj.repository;

import br.com.t1tecnologia.finderj.model.Usuario;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alexandre
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{


    public Usuario findByUsuaLoginAndUsuaSenhaAndUsuaAtivoTrue(String usuario, String senha);
    
    public Usuario findByUsuaLogin(String usuario);

	public Usuario findByUsuaLoginAndUsuaSenhaAndUsuaAtivoFalse(String usuaLogin, String criptografaSenha);

	public List<Usuario> findAllByOrderByIDDesc();
    
}
