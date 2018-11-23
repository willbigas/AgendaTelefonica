package br.com.daoImpl;

import br.com.agendatelefonica.SessionFactory;
import br.com.dao.TipoContatoDao;
import br.com.entidade.TipoContato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class TipoContatoDaoImpl implements TipoContatoDao {

    private Connection conexao;

    @Override
    public boolean inserir(Object obj) throws Exception {
        TipoContato tipoContato = (TipoContato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into tipoContato (nome) values (?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tipoContato.getNome());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Integer idInserido = rs.getInt(1);
                tipoContato.setId(idInserido);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

    @Override
    public boolean update(Object obj) throws Exception {
        TipoContato tipoContato = (TipoContato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update tipoContato set nome = ? where id = ? ");
            statement.setString(1, tipoContato.getNome());
            statement.setInt(2, tipoContato.getId());
            int linhasAtualizadas = statement.executeUpdate();
            return linhasAtualizadas > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

    @Override
    public TipoContato pesquisar(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from tipoContato where id = ? ");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");

                TipoContato tc = new TipoContato();
                tc.setNome(nome);
                tc.setId(id);
                return tc;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }

    @Override
    public List<Object> pesquisarTodos() throws Exception {
        List<Object> tipoContatos = new ArrayList<>();
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from tipoContato");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TipoContato tp = new TipoContato();
                tp.setNome(rs.getString("nome"));
                tp.setId(rs.getInt("id"));
                tipoContatos.add(tp);
            }
            return tipoContatos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return tipoContatos;
    }

    @Override
    public boolean excluir(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "delete from tipoContato where id = ? ");
            statement.setInt(1, id);
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;
        } catch (Exception e) {
            return false;
        } finally {
            conexao.close();
        }
    }

}
