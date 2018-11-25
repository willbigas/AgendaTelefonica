package br.com.agendatelefonica;

import br.com.entidade.Contato;
import br.com.view.JanelaTipoContatoCadastro;
import br.com.view.JanelaContatoCadastro;
import br.com.view.JanelaTipoContatoExcluir;
import br.com.view.JanelaPrincipal;
import br.com.view.JanelaTipoContato;
import br.com.view.JanelaContato;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author William
 */
public class PrincipalAgenda {

    private static JanelaPrincipal frame;

    public static void main(String[] args) {
        JanelaPrincipal();
        
    }

    public static void JanelaPrincipal() {
        frame = new JanelaPrincipal();
        frame.setTitle("Agenda Telefonica");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void JanelaPrincipalContato() throws Exception {
        JanelaContato panel = new JanelaContato(null);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    
    public static void JanelaPrincipalContatoPesquisado(List<Contato> cts) throws Exception {
        JanelaContato panel = new JanelaContato(cts);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void JanelaCadastroContato() {
        JanelaContatoCadastro form = new JanelaContatoCadastro(null);
        frame.setContentPane(form);
        frame.setVisible(true);

    }

    public static void JanelaCadastroContatoEdicao(Contato c) {
        JanelaContatoCadastro form = new JanelaContatoCadastro(c);
        frame.setContentPane(form);
        frame.setVisible(true);
    }

    public static void JanelaCadastroTipoContato() {
        JanelaTipoContatoCadastro frameCadastroTipoContato = new JanelaTipoContatoCadastro();
        frameCadastroTipoContato.setTitle("CADASTRAR TIPO DE CONTATO");
        frameCadastroTipoContato.setExtendedState(JFrame.NORMAL);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }
    
    
    public static void JanelaExcluirTipoContato() {
        JanelaTipoContatoExcluir frameCadastroTipoContato = new JanelaTipoContatoExcluir();
        frameCadastroTipoContato.setTitle("EXCLUIR TIPO DE CONTATO");
        frameCadastroTipoContato.setExtendedState(JFrame.NORMAL);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }
    
     public static void JanelaPrincipalTipoContato() {
         JanelaTipoContato frameCadastroTipoContato = new JanelaTipoContato();
        frameCadastroTipoContato.setTitle("TIPO DE CONTATO");
        frameCadastroTipoContato.setSize(250, 250);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }


}
