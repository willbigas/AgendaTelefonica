package br.com.dao;

import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import java.util.List;

/**
 *
 * @author Alunos
 */
public interface TelefoneDao extends BaseDao {

    public List<Telefone> pesquisarTelefoneContatos(Contato contato) throws Exception;

    public boolean excluirTelefoneContatos(Integer id) throws Exception;

}
