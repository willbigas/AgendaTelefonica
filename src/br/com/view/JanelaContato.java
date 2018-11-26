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
        jLabel1 = new javax.swing.JLabel();
        buttonVoltar = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        tituloContato.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tituloContato.setText("Lista de Contatos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 15, 3);
        add(tituloContato, gridBagConstraints);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(652, 382));

        tabelaContato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabelaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numero", "Contato", "Tipo de Contato", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(tabelaContato);
        if (tabelaContato.getColumnModel().getColumnCount() > 0) {
            tabelaContato.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
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

        buttonBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_buscar_24x24.png"))); // NOI18N
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

        buttonEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_editar_24x24.png"))); // NOI18N
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

        buttonNovo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_novo_24x24.png"))); // NOI18N
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 26, 3, 0);
        jPanel1.add(buttonNovo, gridBagConstraints);

        buttonExcluir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_excluir_24x24.png"))); // NOI18N
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 1, 3, 0);
        jPanel1.add(buttonExcluir, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jPanel1, gridBagConstraints);

        jLabel1.setText("William Bigas Mauro - SENAC PALHOÇA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        add(jLabel1, gridBagConstraints);

        buttonVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_voltar_32x32.png"))); // NOI18N
        buttonVoltar.setMaximumSize(new java.awt.Dimension(58, 32));
        buttonVoltar.setMinimumSize(new java.awt.Dimension(58, 32));
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(buttonVoltar, gridBagConstraints);
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

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int resposta = JOptionPane.showConfirmDialog(this, "Você deseja Realmente excluir Esse contato?\r\nEsta Ação é irreversivel!", "ATENÇÃO!", dialogButton);

        if (resposta == JOptionPane.NO_OPTION) {
            return;
        } else {
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

        }


    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        try {

            PrincipalAgenda.JanelaCadastroContato();
        } catch (Exception exception) {
        }
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
                try {
                    PrincipalAgenda.JanelaCadastroContatoEdicao(c);
                } catch (Exception exception) {
                }
            }

        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuscar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JTextField campoTextoBuscar;
    private javax.swing.JLabel jLabel1;
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
