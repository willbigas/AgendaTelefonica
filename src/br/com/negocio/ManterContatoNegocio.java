/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio;

import br.com.dao.ContatoDao;
import br.com.daoImpl.ContatoDaoImpl;
import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ManterContatoNegocio {

    private static List<Telefone> TELEFONES = new ArrayList();
    private static ContatoDao contatoDao = new ContatoDaoImpl();

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
            if (contato.getNome().toLowerCase().contains(termo.toLowerCase()) || contato.getEmail().toLowerCase().contains(termo.toLowerCase())) {
                retorno.add(contato);
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
