/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agendatelefonica_backup;

import br.com.entidade.Contato;
import br.com.negocio_backup.ManterContatoNegocio;
import br.com.view.FrameCadastroTipoContato;
import br.com.view_backup.FormularioContato;
import br.com.view_backup.FramePrincipal;
import br.com.view_backup.ListarContato;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class PrincipalAgenda {

    private static FramePrincipal frame;

    public static void main(String[] args) {
        frame = new FramePrincipal();
        frame.setTitle("Agenda");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void listarContatos() {
        ListarContato panel = new ListarContato();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void abrirPanelContato() {
        FormularioContato form = new FormularioContato(null);
        frame.setContentPane(form);
        frame.setVisible(true);

    }

    public static void abrirTelaAdicao(Contato c) {
        FormularioContato form = new FormularioContato(c);
        frame.setContentPane(form);
        frame.setVisible(true);
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
