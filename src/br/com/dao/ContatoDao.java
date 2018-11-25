package br.com.dao;

import java.util.List;

/**
 *
 * @author William
 */
public interface ContatoDao extends BaseDao {

    public boolean updateNome(Object obj) throws Exception;

    public boolean updateEmail(Object obj) throws Exception;

    public boolean updateNascimento(Object obj) throws Exception;

    public boolean updateTipoContato(Object obj) throws Exception;

    public boolean updateTelefone(Object obj) throws Exception;

    public List<Object> pesquisarTodosPorTipoOrdenadoPorNome(Integer idTipo) throws Exception;
    
    public List<Object> pesquisarTodosPorTipo(Integer idTipo) throws Exception;
    

}
