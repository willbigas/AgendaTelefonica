/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio;

import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class ManterContatoNegocio {
    
    private static List<Contato> CONTATOS = new ArrayList();
    private static List<Telefone> TELEFONES = new ArrayList();
    private static Integer PROXIMO_ID = 1;
    
    public static void adicionar(Contato contato) {
        if (contato.getId() != null) {
            Contato contatoEditar = obterId(contato.getId());
            contatoEditar.setNome(contato.getNome());
            contatoEditar.setEmail(contato.getEmail());
            contatoEditar.setNascimento(contato.getNascimento());
            contatoEditar.setTipoContato(contato.getTipoContato());
            contatoEditar.setTelefones(contato.getTelefones());
            return;
        }
        contato.setId(PROXIMO_ID);
        CONTATOS.add(contato);
        PROXIMO_ID++;
    }
    
    public static List<Contato> pesquisar(String termo) {
        List<Contato> retorno = new ArrayList();
        for (Contato contato : CONTATOS) {
            if (contato.getNome().toLowerCase().contains(termo.toLowerCase()) || contato.getEmail().toLowerCase().contains(termo.toLowerCase())
                    || contato.getNascimento().equals(termo.toLowerCase())) {
                retorno.add(contato);
            }
            
        }
        return retorno;
    }
    
    public static boolean excluir(Integer id) {
        for (int i = 0; i < CONTATOS.size(); i++) {
            Contato contato = CONTATOS.get(i);
            if (contato.getId().equals(id)) {
                CONTATOS.remove(contato);
                return true;
            }
        }
        return false;
    }
    
    public static Contato obterId(Integer id) {
        for (int i = 0; i < CONTATOS.size(); i++) {
            Contato contato = CONTATOS.get(i);
            if (contato.getId().equals(id)) {
                CONTATOS.remove(contato);
                return contato;
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
