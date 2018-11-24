/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendatelefonica;

import br.com.dao.ContatoDao;
import br.com.dao.TelefoneDao;
import br.com.dao.TipoContatoDao;
import br.com.daoImpl.ContatoDaoImpl;
import br.com.daoImpl.TelefoneDaoImpl;
import br.com.daoImpl.TipoContatoDaoImpl;
import br.com.entidade.TipoContato;

/**
 *
 * @author WILL
 */
public class testandoPersistenciaNovamente {

    public static void main(String[] args) {
        TipoContatoDao tipoContatoDao = new TipoContatoDaoImpl();
        ContatoDao contatoDao = new ContatoDaoImpl();
        TelefoneDao telefoneDao = new TelefoneDaoImpl();

        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome("Pessoal");
    }
}
