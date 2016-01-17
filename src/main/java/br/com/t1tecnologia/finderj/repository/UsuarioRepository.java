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

	public Usuario findByUsuaLoginAndUsuaSenhaAndUsuaAtivoFalse(String usuaLogin, String criptografaSenha);
    
}
