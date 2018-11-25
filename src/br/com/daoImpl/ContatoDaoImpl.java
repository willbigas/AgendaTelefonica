package br.com.daoImpl;

import br.com.agendatelefonica.SessionFactory;
import br.com.dao.ContatoDao;
import br.com.dao.TelefoneDao;
import br.com.dao.TipoContatoDao;
import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import br.com.entidade.TipoContato;
import java.sql.Connection;
import java.sql.Date;
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
public class ContatoDaoImpl implements ContatoDao {

    private Connection conexao;
    private TelefoneDao telefoneDao = new TelefoneDaoImpl();
    private TipoContatoDao tipoContato = new TipoContatoDaoImpl();

    @Override
    public boolean inserir(Object obj) throws Exception {
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into contato (nome , nascimento , email , id_TipoContato) values (? , ? , ? , ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cont.getNome());
            statement.setDate(2, new Date(cont.getNascimento().getTime()));
            statement.setString(3, cont.getEmail());
            if (cont.getTipoContato() == null) {
                statement.setNull(4, Types.INTEGER);
            } else {
                statement.setInt(4, cont.getTipoContato().getId());
            }
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                Integer idInserido = rs.getInt(1);
                cont.setId(idInserido);
                gravarTelefones(cont);
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
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update contato set nome = ? , nascimento = ? , email = ? , id_TipoContato where id = ? ");
            statement.setString(1, cont.getNome());
            statement.setDate(2, new Date(cont.getNascimento().getTime()));
            statement.setString(3, cont.getEmail());
            if (cont.getTipoContato() == null) {
                statement.setNull(4, Types.INTEGER);
            } else {
                statement.setInt(4, cont.getTipoContato().getId());
            }
            statement.setInt(4, cont.getId());
            telefoneDao.excluirTelefoneContatos(cont.getId());
            gravarTelefones(cont);
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
    public Contato pesquisar(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from contato where id = ? ");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                Date nascimento = rs.getDate("nascimento");
                String email = rs.getString("email");
                Integer idTipoContato = rs.getInt("id_TipoContato");
                Contato cont = new Contato();
                cont.setNome(nome);
                cont.setNascimento(nascimento);
                cont.setEmail(email);
                TipoContato tc = (TipoContato) tipoContato.pesquisar(idTipoContato);
                cont.setTipoContato(tc);
                cont.setId(id);
                cont.setTelefones(telefoneDao.pesquisarTelefoneContatos(cont));
                return cont;
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
        List<Object> contatos = new ArrayList<>();
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from contato");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contato cont = new Contato();
                cont.setNome(rs.getString("nome"));
                cont.setEmail(rs.getString("email"));
                cont.setNascimento(rs.getDate("nascimento"));
                Integer idTipoContato = rs.getInt("id_TipoContato");
                cont.setTipoContato((TipoContato) tipoContato.pesquisar(idTipoContato));
                cont.setId(rs.getInt("id"));
                contatos.add(cont);
            }
            return contatos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return contatos;

    }

    @Override
    public boolean excluir(Integer id) throws Exception {
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "delete from contato where id = ? ");
            statement.setInt(1, id);
            int executeUpdate = statement.executeUpdate();
            return executeUpdate != 0;
        } catch (Exception e) {
            return false;
        } finally {
            conexao.close();
        }
    }

    public void gravarTelefones(Contato contato) throws Exception {
        telefoneDao.excluirTelefoneContatos(contato.getId());
        if (contato.getTelefones() != null && !contato.getTelefones().isEmpty()) {
            for (Telefone telefone : contato.getTelefones()) {
                telefone.setContato(contato);
                telefoneDao.inserir(telefone);
            }
        }
    }

    @Override
    public boolean updateNome(Object obj) throws Exception {
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update contato set nome = ? where id = ? ");
            statement.setString(1, cont.getNome());
            statement.setInt(2, cont.getId());
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
    public boolean updateEmail(Object obj) throws Exception {
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update contato set email = ? where id = ? ");
            statement.setString(1, cont.getEmail());
            statement.setInt(2, cont.getId());
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
    public boolean updateNascimento(Object obj) throws Exception {
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update contato set nascimento = ? where id = ? ");
            statement.setDate(1, new Date(cont.getNascimento().getTime()));
            statement.setInt(2, cont.getId());
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
    public boolean updateTipoContato(Object obj) throws Exception {
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update contato set id_tipoContato = ? where id = ? ");
            if (cont.getTipoContato().getId() == null) {
                statement.setNull(1, Types.INTEGER);
            } else {
                statement.setInt(1, cont.getTipoContato().getId());
            }
            statement.setInt(2, cont.getId());
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
    public boolean updateTelefone(Object obj) throws Exception {
        Contato cont = (Contato) obj;
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "update contato set nome = ? where id = ? ");
            statement.setString(1, cont.getNome());
            statement.setInt(2, cont.getId());
            gravarTelefones(cont);
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
    public List<Object> pesquisarTodosPorTipo(Integer idTipo) throws Exception {
        List<Object> contatos = new ArrayList<>();
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from contato where id_tipoContato = ?");
            statement.setInt(1, idTipo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contato cont = new Contato();
                cont.setNome(rs.getString("nome"));
                cont.setEmail(rs.getString("email"));
                cont.setNascimento(rs.getDate("nascimento"));
                Integer idTipoContato = rs.getInt("id_TipoContato");
                cont.setTipoContato((TipoContato) tipoContato.pesquisar(idTipoContato));
                cont.setId(rs.getInt("id"));
                contatos.add(cont);
            }
            return contatos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return contatos;

    }

    @Override
    public List<Object> pesquisarTodosPorTipoOrdenadoPorNome(Integer idTipo) throws Exception {
        List<Object> contatos = new ArrayList<>();
        try {
            conexao = SessionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement(
                    "select * from contato where id_tipoContato = ? order by nome asc");
            statement.setInt(1, idTipo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Contato cont = new Contato();
                cont.setNome(rs.getString("nome"));
                cont.setEmail(rs.getString("email"));
                cont.setNascimento(rs.getDate("nascimento"));
                Integer idTipoContato = rs.getInt("id_TipoContato");
                cont.setTipoContato((TipoContato) tipoContato.pesquisar(idTipoContato));
                cont.setId(rs.getInt("id"));
                contatos.add(cont);
            }
            return contatos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return contatos;

    }

}
