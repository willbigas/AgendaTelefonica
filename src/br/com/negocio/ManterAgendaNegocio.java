package br.com.negocio;

import br.com.entidade.Telefone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class ManterAgendaNegocio {

    private static List<Telefone> TELEFONES = new ArrayList();

    public static List<Telefone> pesquisar(String termo) {
        List<Telefone> retorno = new ArrayList();
        for (Telefone telefone : TELEFONES) {
            if (telefone.getDdd().equals(termo.toLowerCase()) || telefone.getNumero().equals(termo)
                    || telefone.getContato().equals(termo) || telefone.getId().equals(Integer.valueOf(termo))) {
                retorno.add(telefone);
            }

        }
        return retorno;
    }

    public static boolean excluir(Integer id) {
        for (int i = 0; i < TELEFONES.size(); i++) {
            Telefone telefone = TELEFONES.get(i);
            if (telefone.getId().equals(id)) {
                TELEFONES.remove(telefone);
                return true;
            }
        }
        return false;
    }

    public static void adicionarTelefoneNaLista(Telefone tel) {
        if (tel != null) {
            TELEFONES.add(tel);
        }
    }

}
