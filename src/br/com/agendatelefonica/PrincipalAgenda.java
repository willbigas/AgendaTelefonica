package br.com.agendatelefonica;

import br.com.entidade.Contato;
import br.com.view.JanelaContatoCadastro;
import br.com.view.JanelaPrincipal;
import br.com.view.JanelaTipoContato;
import br.com.view.JanelaContato;
import br.com.view.JanelaExportarContatos;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author William
 */
public class PrincipalAgenda {

    private static JanelaPrincipal frame;

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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

    public static void JanelaCadastroContato() throws Exception{
        JanelaContatoCadastro form = new JanelaContatoCadastro(null);
        frame.setContentPane(form);
        frame.setVisible(true);

    }

    public static void JanelaCadastroContatoEdicao(Contato c) throws Exception{
        JanelaContatoCadastro form = new JanelaContatoCadastro(c);
        frame.setContentPane(form);
        frame.setVisible(true);
    }

    public static void JanelaPrincipalTipoContato() {
        JanelaTipoContato frameCadastroTipoContato = new JanelaTipoContato();
        frameCadastroTipoContato.setTitle("TIPO DE CONTATO");
        frameCadastroTipoContato.setSize(600, 600);
        frameCadastroTipoContato.setLocationRelativeTo(null);
        frameCadastroTipoContato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroTipoContato.setVisible(true);
    }

    public static void JanelaExportarContatos() {
        JanelaExportarContatos frameCadastroExportarContatos = new JanelaExportarContatos();
        frameCadastroExportarContatos.setTitle("EXPORTAR CONTATO");
        frameCadastroExportarContatos.setSize(750, 350);
        frameCadastroExportarContatos.setLocationRelativeTo(null);
        frameCadastroExportarContatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCadastroExportarContatos.setVisible(true);
    }

}
