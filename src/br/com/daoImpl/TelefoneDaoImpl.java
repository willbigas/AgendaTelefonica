package br.com.daoImpl;

import br.com.agendatelefonica.SessionFactory;
import br.com.dao.ContatoDao;
import br.com.dao.TelefoneDao;
import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class TelefoneDaoImpl implements TelefoneDao {

    public static ContatoDao contatoDao = new ContatoDaoImpl();

    private Connection conexao;

    @Override
    public boolean inserir(Object obj) throws Exception {
        Telefone tel = (Telefone) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into telefone (ddd , numero , id_contato) values (? , ? , ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, tel.getDdd());
            statement.setString(2, tel.getNumero());
            if (tel.getContato() == null) {
                statement.setNull(3, Types.INTEGER);
            } else {
                statement.setInt(3, tel.getContato().getId());
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Integer idInserido = rs.getInt(1);
                tel.setId(idInserido);
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
        Telefone tel = (Telefone) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update telefone set ddd = ? , set numero = ? , set id_contato = ? where id = ? ");
            statement.setString(1, tel.getDdd());
            statement.setString(2, tel.getNumero());
            if (tel.getContato() == null) {
                statement.setNull(3, Types.INTEGER);
            } else {
                statement.setInt(3, tel.getContato().getId());
            }
            statement.setInt(4, tel.getId());
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
    public Telefone pesquisar(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from telefone where id = ? ");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String ddd = rs.getString("ddd");
                String numero = rs.getString("numero");
                Integer idContato = rs.getInt("id_contato");
                Telefone tel = new Telefone();
                tel.setDdd(ddd);
                tel.setNumero(numero);
                tel.setContato((Contato) contatoDao.pesquisar(idContato));
                tel.setId(id);
                return tel;
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
        List<Object> telefones = new ArrayList<>();
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from telefone");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Telefone tel = new Telefone();
                tel.setDdd(rs.getString("ddd"));
                tel.setNumero(rs.getString("numero"));
                tel.setContato((Contato) contatoDao.pesquisar(rs.getInt("id_contato")));
                tel.setId(rs.getInt("id"));
                telefones.add(tel);
            }
            return telefones;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return telefones;
    }

    @Override
    public boolean excluir(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "delete from telefone where id = ? ");
            statement.setInt(1, id);
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

    @Override
    public List<Telefone> pesquisarTelefoneContatos(Contato contato) throws Exception {
        List<Telefone> telefones = new ArrayList<>();
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from telefone where id_contato = ?");
            statement.setInt(1, contato.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String ddd = rs.getString("ddd");
                String numero = rs.getString("numero");
                Integer idContato = rs.getInt("id_Contato");
                Telefone telefone = new Telefone();
                telefone.setNumero(numero);
                telefone.setId(idContato);
                telefone.setDdd(ddd);
                telefone.setContato(contato);
                telefones.add(telefone);
            }
            return telefones;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return telefones;
    }

    @Override
    public boolean excluirTelefoneContatos(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "delete from telefone where id_contato = ? ");
            statement.setInt(1, id);
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return false;
    }

}
