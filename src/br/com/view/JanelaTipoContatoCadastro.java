package br.com.view;

import br.com.dao.TipoContatoDao;
import br.com.daoImpl.TipoContatoDaoImpl;
import br.com.entidade.TipoContato;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class JanelaTipoContatoCadastro extends javax.swing.JFrame {

    public static TipoContatoDao tipoContatoDao = new TipoContatoDaoImpl();

    /**
     * Creates new form FrameCadastroContato
     */
    public JanelaTipoContatoCadastro() {
        initComponents();

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

        stringTipoContato = new javax.swing.JLabel();
        campoTipoContato = new javax.swing.JTextField();
        botaoGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        stringTipoContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stringTipoContato.setText("TIPO DE CONTATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        getContentPane().add(stringTipoContato, gridBagConstraints);

        campoTipoContato.setColumns(15);
        campoTipoContato.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        getContentPane().add(campoTipoContato, gridBagConstraints);

        botaoGravar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoGravar.setText("GRAVAR");
        botaoGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGravarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 6, 3);
        getContentPane().add(botaoGravar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGravarActionPerformed
        // TODO add your handling code here:
        TipoContato tipoContato = new TipoContato();
        tipoContato.setNome(campoTipoContato.getText());
        try {

            Boolean tudoOk = tipoContatoDao.inserir(tipoContato);
            if (tudoOk) {
                JOptionPane.showMessageDialog(this, "Tipo de Contato Inserido");
                JanelaPrincipal.getWindows();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Problemas ao Persistir");
        }
    }//GEN-LAST:event_botaoGravarActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaTipoContatoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaTipoContatoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaTipoContatoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaTipoContatoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaTipoContatoCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGravar;
    private javax.swing.JTextField campoTipoContato;
    private javax.swing.JLabel stringTipoContato;
    // End of variables declaration//GEN-END:variables
}