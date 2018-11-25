package br.com.dao;

import br.com.entidade.TipoContato;

/**
 *
 * @author William
 */
public interface TipoContatoDao extends BaseDao {
    
    public TipoContato pesquisarPorNome(String nome)throws Exception;

}
