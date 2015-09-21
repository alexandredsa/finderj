package br.com.t1tecnologia.finderj.repository;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alexandre
 */
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    public Empresa findByEmprNome(String nomeEmpresa);

    public Empresa findByEmprUsuario(Usuario usuario);

}
