package br.com.negocio;

import br.com.dao.ContatoDao;
import br.com.dao.TipoContatoDao;
import br.com.daoImpl.ContatoDaoImpl;
import br.com.daoImpl.TipoContatoDaoImpl;
import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import br.com.entidade.TipoContato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class ManterContatoNegocio {

    private static List<Telefone> TELEFONES = new ArrayList();
    private static ContatoDao contatoDao = new ContatoDaoImpl();
    private static TipoContatoDao tipoContatoDao = new TipoContatoDaoImpl();

    public static void adicionar(Contato contato) throws Exception {
        if (contato.getId() != null) {
            Contato contatoEditar = obterId(contato.getId());
            contatoEditar.setNome(contato.getNome());
            contatoEditar.setEmail(contato.getEmail());
            contatoEditar.setNascimento(contato.getNascimento());
            contatoEditar.setTipoContato(contato.getTipoContato());
            contatoEditar.setTelefones(contato.getTelefones());
            return;
        }
    }

    public static List<Contato> pesquisar(String termo) throws Exception {
        List<Contato> retorno = new ArrayList();
        List<?> objs = contatoDao.pesquisarTodos();
        List<Contato> CONTATOS = (List<Contato>) (Object) objs;

        for (Contato contato : CONTATOS) {
            if (contato.getNome().toLowerCase().contains(termo.toLowerCase())
                    || contato.getEmail().toLowerCase().contains(termo.toLowerCase())
                    || contato.getTipoContato().getNome().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(contato);
            }

        }
        return retorno;
    }

    public static List<TipoContato> pesquisarTipoContato(String termo) throws Exception {
        List<TipoContato> retorno = new ArrayList();
        List<?> objs = tipoContatoDao.pesquisarTodos();
        List<TipoContato> TIPOS_DE_CONTATO = (List<TipoContato>) (Object) objs;

        for (TipoContato tipoContato : TIPOS_DE_CONTATO) {
            if (tipoContato.getNome().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(tipoContato);
            }

        }
        return retorno;
    }

    public static boolean excluir(Integer id) throws Exception {

        List<?> objs = contatoDao.pesquisarTodos();
        List<Contato> CONTATOS = (List<Contato>) (Object) objs;
        for (int i = 0; i < CONTATOS.size(); i++) {
            Contato contato = CONTATOS.get(i);
            if (contato.getId().equals(id)) {
                CONTATOS.remove(contato);
                contatoDao.excluir(id);
                return true;
            }
        }
        return false;
    }

    public static Contato obterId(Integer id) throws Exception {

        List<?> objs = contatoDao.pesquisarTodos();
        List<Contato> CONTATOS = (List<Contato>) (Object) objs;
        for (int i = 0; i < CONTATOS.size(); i++) {
            Contato contato = CONTATOS.get(i);
            if (contato.getId().equals(id)) {
                Contato ContatoPesquisado = (Contato) contatoDao.pesquisar(id);
                contatoDao.excluir(id);
                return ContatoPesquisado;
            }
        }
        return null;
    }

    public static void adicionarTelefoneNaLista(Telefone tel) {
        if (tel != null) {
            TELEFONES.add(tel);
        }
    }

    public static List<Telefone> pesquisarTelefones(String termo) {
        List<Telefone> retorno = new ArrayList();
        for (Telefone telefone : TELEFONES) {
            if (telefone.getDdd().equals(termo.toLowerCase()) || telefone.getNumero().equals(termo.toLowerCase())
                    || telefone.getContato().getNome().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(telefone);
            }

        }
        return retorno;
    }

}
