package br.com.t1tecnologia.finderj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.t1tecnologia.finderj.model.Empresa;
import br.com.t1tecnologia.finderj.model.Usuario;

/**
 *
 * @author alexandre
 */
@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

	public Empresa findByEmprNome(String nomeEmpresa);

	public Empresa findByEmprUsuario(Usuario usuario);

	@Query("select distinct e from Empresa e join fetch e.emprVaga v where v.vagaDtTermino is null")
	public List<Empresa> findAllFetchEagerVagasAtivas();

}
