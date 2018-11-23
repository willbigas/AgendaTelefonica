package br.com.agendatelefonica;

import javax.swing.JFrame;
import br.com.view.FrameCadastroContato;
import br.com.view.FrameCadastroTipoContato;
import br.com.view.FramePrincipal;

/**
 *
 * @author William
 */
public class PrincipalComSwing {

    private static FramePrincipal frame;

    public static void main(String[] args) {

        frame = new FramePrincipal();
        frame.setTitle("AGENDA TELEFONICA");
        frame.setExtendedState(JFrame.NORMAL);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void frameCadastroContato() {
        FrameCadastroContato frameCadastroContato = new FrameCadastroContato();
        frameCadastroContato.setTitle("CADASTRAR CONTATO");
        frameCadastroContato.setExtendedState(JFrame.NORMAL);
        frameCadastroContato.setLocationRelativeTo(null);
        frameCadastroContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroContato.setVisible(true);
    }

    public static void frameCadastroTipoContato() {
        FrameCadastroTipoContato frameCadastroTipoContato = new FrameCadastroTipoContato();
        frameCadastroTipoContato.setTitle("CADASTRAR TIPO DE CONTATO");
        frameCadastroTipoContato.setExtendedState(JFrame.NORMAL);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }

}
