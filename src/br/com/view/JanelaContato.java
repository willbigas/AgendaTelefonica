package br.com.view;

import br.com.agendatelefonica.PrincipalAgenda;
import br.com.dao.ContatoDao;
import br.com.dao.TelefoneDao;
import br.com.daoImpl.ContatoDaoImpl;
import br.com.daoImpl.TelefoneDaoImpl;
import br.com.entidade.Contato;
import br.com.negocio.ManterContatoNegocio;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author William
 */
public class JanelaContato extends javax.swing.JPanel {

    /**
     * Creates new form ListarContato
     */
    public JanelaContato(List<Contato> CONTATOS) throws Exception {
        initComponents();

        if (CONTATOS != null) {
            adicionarListaContatosTabela(CONTATOS);
        } else {
            List<Contato> contatos = ManterContatoNegocio.pesquisar("");
            adicionarListaContatosTabela(contatos);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tituloContato = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContato = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JLabel();
        campoTextoBuscar = new javax.swing.JTextField();
        buttonBuscar = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tituloContato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tituloContato.setText("Contato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 15, 3);
        add(tituloContato, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(652, 382));

        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaContato);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 3, 3, 3);
        add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        textoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoBuscar.setText("Busca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(textoBuscar, gridBagConstraints);

        campoTextoBuscar.setColumns(15);
        campoTextoBuscar.setText("Buscar por...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(campoTextoBuscar, gridBagConstraints);

        buttonBuscar.setText("Buscar");
        buttonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(buttonBuscar, gridBagConstraints);

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(buttonEditar, gridBagConstraints);

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(buttonNovo, gridBagConstraints);

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(buttonExcluir, gridBagConstraints);

        buttonSair.setText("Sair");
        buttonSair.setMaximumSize(new java.awt.Dimension(58, 32));
        buttonSair.setMinimumSize(new java.awt.Dimension(58, 32));
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(buttonSair, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuscarActionPerformed

        List<Contato> contatos = null;
        try {
            contatos = ManterContatoNegocio.pesquisar(campoTextoBuscar.getText());
        } catch (Exception exception) {
        }
        adicionarListaContatosTabela(contatos);

    }//GEN-LAST:event_buttonBuscarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        TelefoneDao telefoneDao = new TelefoneDaoImpl();
        int linha = tabelaContato.getSelectedRow();
        if (linha >= 0) {
            String idContato = (String) tabelaContato.getValueAt(linha, 0);

            boolean apagou = false;
            ContatoDao contatoDao = new ContatoDaoImpl();
            try {
                telefoneDao.excluirTelefoneContatos(Integer.valueOf(idContato));
                apagou = contatoDao.excluir(Integer.valueOf(idContato));
                System.out.println(idContato);
            } catch (Exception exception) {
            }
            if (apagou) {
                JOptionPane.showMessageDialog(this, "Contato excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível excluir o contato , Verifique suas Dependencias");

            }
        }
        try {
            List<Contato> contatos = ManterContatoNegocio.pesquisar("");
            adicionarListaContatosTabela(contatos);
        } catch (Exception exception) {
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        PrincipalAgenda.JanelaCadastroContato();
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed

        ContatoDao contatoDao = new ContatoDaoImpl();
        int linha = tabelaContato.getSelectedRow();
        if (linha >= 0) {
            String idContato = (String) tabelaContato.getValueAt(linha, 0);
            Integer id = Integer.valueOf(idContato);
            Contato c = null;
            try {
                c = (Contato) contatoDao.pesquisar(id);
            } catch (Exception exception) {
            }
            if (c != null) {
                PrincipalAgenda.JanelaCadastroContatoEdicao(c);
            }

        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonSair;
    private javax.swing.JTextField campoTextoBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaContato;
    private javax.swing.JLabel textoBuscar;
    private javax.swing.JLabel tituloContato;
    // End of variables declaration//GEN-END:variables

    public void adicionarListaContatosTabela(List<Contato> contatos) {
        String[] colunas = {"Codigo", "Nome", "TipoContato", "Email"};
        String[][] dados = new String[contatos.size()][colunas.length];
        for (int i = 0; i < contatos.size(); i++) {
            Contato c = contatos.get(i);
            dados[i][0] = c.getId().toString();
            dados[i][1] = c.getNome();
            if (c.getTipoContato() == null) {
                dados[i][2] = "Não informado";
            } else {
                dados[i][2] = c.getTipoContato().getNome();

            }
            dados[i][3] = c.getEmail();

        }
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        tabelaContato.setModel(modelo);
    }

}
