package br.com.agendatelefonica;

import br.com.dao.ContatoDao;
import br.com.dao.TelefoneDao;
import br.com.dao.TipoContatoDao;
import br.com.daoImpl.ContatoDaoImpl;
import br.com.daoImpl.TelefoneDaoImpl;
import br.com.daoImpl.TipoContatoDaoImpl;

/**
 *
 * @author WILL
 */
public class Principal {

    public static TipoContatoDao tipoContatoDao = new TipoContatoDaoImpl();
    public static ContatoDao contatoDao = new ContatoDaoImpl();
    public static TelefoneDao telefoneDao = new TelefoneDaoImpl();

    public static void main(String[] args) throws Exception {

        ManterAgendaTelefonicaNegocio.menuPrincipal();

    }

}
