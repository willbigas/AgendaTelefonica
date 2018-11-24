package br.com.agendatelefonica;

import br.com.entidade.Contato;
import br.com.view.FrameCadastroTipoContato;
import br.com.view.FrameCadastroContato;
import br.com.view.FrameExcluirTipoContato;
import br.com.view.FramePrincipal;
import br.com.view.FrameTipoContato;
import br.com.view.ListarContato;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Felipe
 */
public class PrincipalAgenda {

    private static FramePrincipal frame;

    public static void main(String[] args) {
        JanelaPrincipal();
        
    }

    public static void JanelaPrincipal() {
        frame = new FramePrincipal();
        frame.setTitle("Agenda Telefonica");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void JanelaPrincipalContato() throws Exception {
        ListarContato panel = new ListarContato(null);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    
    public static void JanelaPrincipalContatoPesquisado(List<Contato> cts) throws Exception {
        ListarContato panel = new ListarContato(cts);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void JanelaCadastroContato() {
        FrameCadastroContato form = new FrameCadastroContato(null);
        frame.setContentPane(form);
        frame.setVisible(true);

    }

    public static void JanelaCadastroContatoEdicao(Contato c) {
        FrameCadastroContato form = new FrameCadastroContato(c);
        frame.setContentPane(form);
        frame.setVisible(true);
    }

    public static void JanelaCadastroTipoContato() {
        FrameCadastroTipoContato frameCadastroTipoContato = new FrameCadastroTipoContato();
        frameCadastroTipoContato.setTitle("CADASTRAR TIPO DE CONTATO");
        frameCadastroTipoContato.setExtendedState(JFrame.NORMAL);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }
    
    
    public static void JanelaExcluirTipoContato() {
        FrameExcluirTipoContato frameCadastroTipoContato = new FrameExcluirTipoContato();
        frameCadastroTipoContato.setTitle("EXCLUIR TIPO DE CONTATO");
        frameCadastroTipoContato.setExtendedState(JFrame.NORMAL);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }
    
     public static void JanelaPrincipalTipoContato() {
         FrameTipoContato frameCadastroTipoContato = new FrameTipoContato();
        frameCadastroTipoContato.setTitle("TIPO DE CONTATO");
        frameCadastroTipoContato.setSize(250, 250);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }


}
