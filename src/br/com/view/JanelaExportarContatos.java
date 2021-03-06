/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.dao.ContatoDao;
import br.com.dao.TelefoneDao;
import br.com.dao.TipoContatoDao;
import br.com.daoImpl.ContatoDaoImpl;
import br.com.daoImpl.TelefoneDaoImpl;
import br.com.daoImpl.TipoContatoDaoImpl;
import br.com.entidade.Contato;
import br.com.entidade.Telefone;
import br.com.entidade.TipoContato;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WILL
 */
public class JanelaExportarContatos extends javax.swing.JFrame {

    public static ContatoDao contatoDao = new ContatoDaoImpl();
    public static TelefoneDao telefoneDao = new TelefoneDaoImpl();
    public static TipoContatoDao tipoContatoDao = new TipoContatoDaoImpl();

    /**
     * Creates new form JanelaExportarContatos
     */
    public JanelaExportarContatos() {
        initComponents();
        try {

            List<TipoContato> tipoContatos = (List<TipoContato>) (Object) tipoContatoDao.pesquisarTodos();
            adicionarListaTipoContatosTabela(tipoContatos);
        } catch (Exception exception) {
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

        painelTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTipoTelefone = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        painelExportacao = new javax.swing.JPanel();
        checkBoxNormal = new javax.swing.JCheckBox();
        checkboxTipo = new javax.swing.JCheckBox();
        textoTipoExportacao = new javax.swing.JLabel();
        bottonExportar = new javax.swing.JButton();
        painelOrdenacao = new javax.swing.JPanel();
        textoTipoOrdenacao = new javax.swing.JLabel();
        checkBoxTipoOrdenacaoNormal = new javax.swing.JCheckBox();
        checkBoxTipoOrdenacaoNome = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaTipoTelefone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "TIPO DE TELEFONE"
            }
        ));
        tabelaTipoTelefone.setPreferredSize(null);
        jScrollPane1.setViewportView(tabelaTipoTelefone);

        javax.swing.GroupLayout painelTabelaLayout = new javax.swing.GroupLayout(painelTabela);
        painelTabela.setLayout(painelTabelaLayout);
        painelTabelaLayout.setHorizontalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTabelaLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelTabelaLayout.setVerticalGroup(
            painelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        checkBoxNormal.setText("Normal");

        checkboxTipo.setText("Filtrado por Tipo");

        textoTipoExportacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textoTipoExportacao.setText("Tipos de Exportação");
        textoTipoExportacao.setPreferredSize(new java.awt.Dimension(12040, 12040));

        bottonExportar.setText("Exportar");
        bottonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bottonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelExportacaoLayout = new javax.swing.GroupLayout(painelExportacao);
        painelExportacao.setLayout(painelExportacaoLayout);
        painelExportacaoLayout.setHorizontalGroup(
            painelExportacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelExportacaoLayout.createSequentialGroup()
                .addGroup(painelExportacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelExportacaoLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(bottonExportar))
                    .addGroup(painelExportacaoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(painelExportacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkboxTipo)
                            .addComponent(checkBoxNormal)))
                    .addComponent(textoTipoExportacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        painelExportacaoLayout.setVerticalGroup(
            painelExportacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelExportacaoLayout.createSequentialGroup()
                .addComponent(textoTipoExportacao, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkboxTipo)
                .addGap(26, 26, 26)
                .addComponent(bottonExportar))
        );

        textoTipoOrdenacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textoTipoOrdenacao.setText("Tipos de Ordenacao");

        checkBoxTipoOrdenacaoNormal.setText("Normal");

        checkBoxTipoOrdenacaoNome.setText("Nome");
        checkBoxTipoOrdenacaoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxTipoOrdenacaoNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelOrdenacaoLayout = new javax.swing.GroupLayout(painelOrdenacao);
        painelOrdenacao.setLayout(painelOrdenacaoLayout);
        painelOrdenacaoLayout.setHorizontalGroup(
            painelOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrdenacaoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(painelOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxTipoOrdenacaoNome)
                    .addComponent(checkBoxTipoOrdenacaoNormal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOrdenacaoLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(textoTipoOrdenacao)
                .addGap(37, 37, 37))
        );
        painelOrdenacaoLayout.setVerticalGroup(
            painelOrdenacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOrdenacaoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(textoTipoOrdenacao)
                .addGap(18, 18, 18)
                .addComponent(checkBoxTipoOrdenacaoNormal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxTipoOrdenacaoNome)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(painelExportacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(painelOrdenacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelExportacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("EXPORTACAO DE RELATÓRIO EM CSV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(125, 125, 125))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bottonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bottonExportarActionPerformed
        if (!checkBoxNormal.isSelected() && !checkboxTipo.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione Pelomenos um item de cada Tipo!");
            return;
        }

        if (!checkBoxTipoOrdenacaoNome.isSelected() && !checkBoxTipoOrdenacaoNormal.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione Pelomenos um item de cada Ordenação!");
            return;
        }
        if (validandoCampos()) {
            return;
        }
        if (checkBoxNormal.isSelected() && checkBoxTipoOrdenacaoNormal.isSelected()) {
            seForNormal();
        }
        if (checkBoxNormal.isSelected() && checkBoxTipoOrdenacaoNome.isSelected()) {
            seForNormalComOrdenacaoPorNome();
        }
        if (checkboxTipo.isSelected() && checkBoxTipoOrdenacaoNormal.isSelected()) {
            seForTipo();
        }

        if (checkBoxTipoOrdenacaoNome.isSelected() && checkboxTipo.isSelected()) {
            seForTipoENome();
        }


    }//GEN-LAST:event_bottonExportarActionPerformed

    private void checkBoxTipoOrdenacaoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxTipoOrdenacaoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxTipoOrdenacaoNomeActionPerformed

    private void seForTipoENome() throws NumberFormatException {
        int linhaTipo = tabelaTipoTelefone.getSelectedRow();
        if (linhaTipo >= 0) {
            String campoSelecionadoTipo = (String) tabelaTipoTelefone.getValueAt(linhaTipo, 0);

            Integer campoIdTipoContatoSelecionado = Integer.valueOf(campoSelecionadoTipo);

            try {
                String mensagem = null;
                Integer id = null;
                List<TipoContato> TIPOCONTATO = (List<TipoContato>) (Object) tipoContatoDao.pesquisarTodos();
                for (int i = 0; i < TIPOCONTATO.size(); i++) {
                    TipoContato get = TIPOCONTATO.get(i);
                }
                seForNormalComFiltroDeTipoOrdenadoPorNome(campoIdTipoContatoSelecionado);
            } catch (Exception exception) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Tipo de Contato Selecionado , Favor Selecione um!");
        }
    }

    private void seForTipo() throws NumberFormatException {
        int linha = tabelaTipoTelefone.getSelectedRow();
        if (linha >= 0) {
            String campoSelecionado = (String) tabelaTipoTelefone.getValueAt(linha, 0);
            Integer campoIdTipoContatoSelecionado = Integer.valueOf(campoSelecionado);

            try {

                String mensagem = null;
                List<TipoContato> TIPOCONTATO = (List<TipoContato>) (Object) tipoContatoDao.pesquisarTodos();
                for (int i = 0; i < TIPOCONTATO.size(); i++) {
                    TipoContato get = TIPOCONTATO.get(i);
                }
                seForNormalComFiltroDeTipo(campoIdTipoContatoSelecionado);
            } catch (Exception exception) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Tipo de Contato Selecionado , Favor Selecione um!");
        }
    }

    private boolean validandoCampos() throws HeadlessException {

        if (!checkboxTipo.isSelected() && !checkBoxNormal.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione apenas um Tipo!");
            return true;
        }
        if (checkBoxTipoOrdenacaoNome.isSelected() && checkBoxTipoOrdenacaoNormal.isSelected()) {
            JOptionPane.showMessageDialog(null, "Selecione apenas um dos campos!");
            return true;
        }
        return false;
    }

    public void seForNormal() throws HeadlessException {
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivo Csv - Excel 2007 ou Superior", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = chooser.getSelectedFile().getName();
            String enderecoArquivo = chooser.getSelectedFile().getPath();

            try {
                String impressao = transformandoEmListaSimples();
                br.com.utilpacket.Util_Arquivo.escreverArq(enderecoArquivo + ".csv", impressao);
                JOptionPane.showMessageDialog(this, "Arquivo salvo com Sucesso!");

            } catch (Exception exception) {
            }

        }
    }

    public void seForNormalComOrdenacaoPorNome() throws HeadlessException {
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivo Csv - Excel 2007 ou Superior", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = chooser.getSelectedFile().getName();
            String enderecoArquivo = chooser.getSelectedFile().getPath();

            try {
                String impressao = transformandoEmListaSimplesOrdenadoPorNome();
                br.com.utilpacket.Util_Arquivo.escreverArq(enderecoArquivo + ".csv", impressao);
                JOptionPane.showMessageDialog(this, "Arquivo salvo com Sucesso!");

            } catch (Exception exception) {
            }

        }
    }

    public void seForNormalComFiltroDeTipo(Integer id) throws HeadlessException {
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivo Csv - Excel 2007 ou Superior", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = chooser.getSelectedFile().getName();
            String enderecoArquivo = chooser.getSelectedFile().getPath();

            try {
                String impressao = transformandoEmListaSimplesComFiltroDeTipo(id);
                br.com.utilpacket.Util_Arquivo.escreverArq(enderecoArquivo + ".csv", impressao);
                JOptionPane.showMessageDialog(this, "Arquivo salvo com Sucesso!");

            } catch (Exception exception) {
            }

        }
    }

    public void seForNormalComFiltroDeTipoOrdenadoPorNome(Integer id) throws HeadlessException {
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Arquivo Csv - Excel 2007 ou Inferior", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String nomeArquivo = chooser.getSelectedFile().getName();
            String enderecoArquivo = chooser.getSelectedFile().getPath();

            try {
                String impressao = transformandoEmListaSimplesComFiltroDeTipoOrdenadoPorNome(id);
                br.com.utilpacket.Util_Arquivo.escreverArq(enderecoArquivo + ".csv", impressao);
                JOptionPane.showMessageDialog(this, "Arquivo salvo com Sucesso!");

            } catch (Exception exception) {
            }

        }
    }

    public static String transformandoEmListaSimples() throws Exception {
        // Opcao 1 //

        String impressao = new String();
        List<Contato> CONTATOS = (List<Contato>) (Object) contatoDao.pesquisarTodos();
        for (int i = 0; i < CONTATOS.size(); i++) {
            Contato get = CONTATOS.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }
        return impressao;

    }

    public static String transformandoEmListaSimplesOrdenadoPorNome() throws Exception {
        // Opcao 1 //

        String impressao = new String();
        List<Contato> CONTATOS = (List<Contato>) (Object) contatoDao.pesquisarTodosOrdenadoPorNome();
        for (int i = 0; i < CONTATOS.size(); i++) {
            Contato get = CONTATOS.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }
        return impressao;

    }

    public static String transformandoEmListaSimplesComFiltroDeTipo(Integer id) throws Exception {
        // Opcao 1 //
        String impressao = new String();

        List<Object> object = contatoDao.pesquisarTodosPorTipo(id);
        for (int i = 0; i < object.size(); i++) {
            Contato get = (Contato) object.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }

        return impressao;
    }

    public static String transformandoEmListaSimplesComFiltroDeTipoOrdenadoPorNome(Integer id) throws Exception {
        // Opcao 1 //
        String impressao = "";
        List<Object> object = contatoDao.pesquisarTodosPorTipoOrdenadoPorNome(id);
//        List<Contato> listaContato = new ArrayList<>();
//        for (int i = 0; i < object.size(); i++) {
//            Contato get = (Contato) object.get(i);
//            listaContato.add(get);
//        }
//        for (Contato c : listaContato) {
//            impressao += c.getNome() + ";" + c.getEmail() + ";" + c.getNascimento() + ";";
//            for (Telefone t : c.getTelefones()) {
//                impressao += t.getDdd() + ";" + t.getNumero() + ";";
//            }
//            impressao += "\r\n";
//        }
//        return impressao;

        for (int i = 0; i < object.size(); i++) {
            Contato get = (Contato) object.get(i);
            List<Telefone> TELEFONES_DO_CONTATO = telefoneDao.pesquisarTelefoneContatos(get);
            for (int j = 0; j < TELEFONES_DO_CONTATO.size(); j++) {
                Telefone telContato = TELEFONES_DO_CONTATO.get(j);
                impressao = impressao + get.getNome() + ";" + get.getEmail() + ";" + get.getNascimento() + ";" + get.getTipoContato().getNome() + ";" + "(" + telContato.getDdd() + ")" + telContato.getNumero() + ";\r\n";
            }
        }
        return impressao;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaExportarContatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaExportarContatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottonExportar;
    private javax.swing.JCheckBox checkBoxNormal;
    private javax.swing.JCheckBox checkBoxTipoOrdenacaoNome;
    private javax.swing.JCheckBox checkBoxTipoOrdenacaoNormal;
    private javax.swing.JCheckBox checkboxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelExportacao;
    private javax.swing.JPanel painelOrdenacao;
    private javax.swing.JPanel painelTabela;
    private javax.swing.JTable tabelaTipoTelefone;
    private javax.swing.JLabel textoTipoExportacao;
    private javax.swing.JLabel textoTipoOrdenacao;
    // End of variables declaration//GEN-END:variables
public void adicionarListaTipoContatosTabela(List<TipoContato> tipoContatos) {
        String[] colunas = {"Codigo", "TipoContato"};
        String[][] dados = new String[tipoContatos.size()][colunas.length];
        for (int i = 0; i < tipoContatos.size(); i++) {
            TipoContato tc = tipoContatos.get(i);
            dados[i][0] = tc.getId().toString();
            dados[i][1] = tc.getNome();
        }
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        tabelaTipoTelefone.setModel(modelo);
    }
}
